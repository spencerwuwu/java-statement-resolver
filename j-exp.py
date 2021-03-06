#!/usr/bin/python2.7
import os
import signal
from subprocess import Popen, PIPE
import time
import sys
import subprocess, threading

Reducer = "reducer.java"
Mvn = "mvn package -q -Dmaven.test.skip=true -B"
TIMEOUT = 300

def error_exit(path):
    os.system("rm -rf " + path)
    exit(1)

### Process timer
def wait_timeout(proc, timeout):
    start = time.time()
    end = start + timeout
    interval = .25
    while True:
        result = proc.poll()
        if result is not None:
            return True
        if time.time() >= end:
            os.killpg(os.getpgid(proc.pid), signal.SIGKILL)
            return False
        time.sleep(interval)


def parse_param1(target):
    tokens = target.split(" ")
    if (len(tokens) == 2):
        return tokens[0]
    else:
        return tokens[1]

def parse_param2(target):
    return target.split("<")[1].split(">")[0]

def parse_param_o(target):
    tokens = target.split("<")[1].split(">")[0].replace(" ", "").split(",")
    return tokens[0], tokens[1]

def get_type():
    if (len(sys.argv) == 2):
        target_f = open(sys.argv[1], "r")
    else:
        target_f = open(Reducer, "r")
    t1 = ""
    t2 = ""
    t3 = ""
    t4 = ""
    r_type = ""
    lines = target_f.read()
    if "public void reduce" in lines:
        lines = lines.replace("\r", "").replace("\n", "").replace("\t", "").split("public void reduce")[1]
    elif "protected void reduce" in lines:
        lines = lines.replace("\r", "").replace("\n", "").replace("\t", "").split("protected void reduce")[1]
    else:
        print "No reduce found"
        exit(1)


    params = lines.split("(")[1].split(")")[0].split(",")

    if (len(params) == 3):
        r_type = "Context"
        t1 = parse_param1(params[0])
        t2 = parse_param2(params[1])
        t3 = t1
        t4 = t2
    elif (len(params) == 5):
        r_type = "Collector"
        t1 = parse_param1(params[0])
        t2 = parse_param2(params[1])
        t3, t4 = parse_param_o(params[2] + "," +  params[3])
    target_f.close()
    #print t1 + " " + t2 + " " + t3 + " " + t4 + " " + r_type
    return t1, t2, t3, t4, r_type


def compile(T1, T2, T3, T4, r_type, global_path, path):
    wrapper = global_path + "templates/wrapper"
    autoGenerator = path + "src/main/java/reduce_test/autoGenerator.java"
    template_path = global_path + "templates/build"
    os.system("cp -r " + template_path + " " + path)

    if "Collector" in r_type:
        wrapper = wrapper + "_o.java"
    else:
        wrapper = wrapper + "_c.java"

    wrapper_f = open(wrapper, "r")
    if len(sys.argv) == 2:
        reducer_f = open(sys.argv[1], "r")
    elif len(sys.argv) == 7:
        reducer_f = open(sys.argv[6], "r")
    else:
        reducer_f = open(global_path + Reducer, "r")
    generator_f = open(autoGenerator, "w")

    for line in wrapper_f.readlines():
        if "T1_" in line:
            if "IntWritable" in T1:
                generator_f.write("new IntWritable(key)")
            elif "NullWritable" in T1:
                generator_f.write("new NullWritable()")
            elif "Text" in T1:
                generator_f.write("new Text(key)")
            elif "BytesWritable" in T1:
                generator_f.write("new BytesWritable(key)")
            elif "LongWritable" in T1:
                generator_f.write("new LongWritable(key)")
            elif "DoubleWritable" in T1:
                generator_f.write("new DoubleWritable(key)")
            elif "FloatWritable" in T1:
                generator_f.write("new FloatWritable(key)")
            elif "BooleanWritable" in T1:
                generator_f.write("new BooleanWritable(key)")
            elif "Integer" in T1:
                generator_f.write("key")
            elif "Long" in T1:
                generator_f.write("key")
            elif "Double" in T1:
                generator_f.write("key")
            elif "Float" in T1:
                generator_f.write("key")
        elif "T1" in line:
            generator_f.write(T1)
        elif "T2" in line:
            generator_f.write(T2)
        elif "T3" in line:
            generator_f.write(T3)
        elif "T4" in line:
            generator_f.write(T4)
        elif "INPUT0" in line:
            if "IntWritable" in T2:
                generator_f.write("IntWritable[] solutionArray = new IntWritable[length];\n")
            elif "LongWritable" in T2:
                generator_f.write("LongWritable[] solutionArray = new LongWritable[length];\n")
            elif "Integer" in T2:
                generator_f.write("Integer[] solutionArray = new Integer[length];\n")
            elif "Long" in T2:
                generator_f.write("Long[] solutionArray = new Long[length];\n")
            elif "DoubleWritable" in T2:
                generator_f.write("DoubleWritable[] solutionArray = new DoubleWritable[length];\n")
            elif "Double" in T2:
                generator_f.write("Double[] solutionArray = new Double[length];\n")
            elif "FloatWritable" in T2:
                generator_f.write("FloatWritable[] solutionArray = new FloatWritable[length];\n")
            elif "Float" in T2:
                generator_f.write("Float[] solutionArray = new Float[length];\n")
        elif "KEYGEN" in line:
            if "IntWritable" in T1:
                generator_f.write("int key = (int)(Math.random() * 10 + 1) - 5;\n")
            elif "Text" in T1:
                generator_f.write("byte[] key = new byte[1];key[0] = (byte)('a' + (int)(Math.random() * 26));")
            elif "BytesWritable" in T1:
                generator_f.write("byte[] key = new byte[1];key[0] = (byte)('a' + (int)(Math.random() * 26));")
            elif "LongWritable" in T1:
                generator_f.write("long key = (long)(Math.random() * 10 + 1) - 5;\n")
            elif "DoubleWritable" in T1:
                generator_f.write("double key = (double)(Math.random() * 10 + 1) - 5;\n")
            elif "FloatWritable" in T1:
                generator_f.write("float key = (float)(Math.random() * 10 + 1) - 5;\n")
            elif "Double" in T1:
                generator_f.write("double key = (double)(Math.random() * 10 + 1) - 5;\n")
            elif "Float" in T1:
                generator_f.write("float key = (float)(Math.random() * 10 + 1) - 5;\n")
            elif "BooleanWritable" in T1:
                generator_f.write("boolean key = (int)(Math.random()*10+1)-5 > 0 ? true:false;")
            elif "Integer" in T1:
                generator_f.write("int key = (int)(Math.random() * 10 + 1) - 5;\n")
            elif "Long" in T1:
                generator_f.write("long key = (long)(Math.random() * 10 + 1) - 5;\n")
        elif "RANDOM" in line:
            if "IntWritable" in T2:
                generator_f.write("int random = (int)(Math.random() * 10 + 1) - 5;\n")
                generator_f.write("solutionArray[j] = new IntWritable(random);\n")
            elif "LongWritable" in T2:
                generator_f.write("long random = (long)(Math.random() * 10 + 1) - 5;\n")
                generator_f.write("solutionArray[j] = new LongWritable(random);\n")
            elif "Integer" in T2:
                generator_f.write("int random = (int)(Math.random() * 10 + 1) - 5;\n")
                generator_f.write("solutionArray[j] = random;\n")
            elif "Long" in T2:
                generator_f.write("long random = (long)(Math.random() * 10 + 1) - 5;\n")
                generator_f.write("solutionArray[j] = random;\n")
            elif "DoubleWritable" in T2:
                generator_f.write("double random = (int)(Math.random() * 10 + 1) - 5;\n")
                generator_f.write("solutionArray[j] = new DoubleWritable(random);\n")
            elif "Double" in T2:
                generator_f.write("double random = (int)(Math.random() * 10 + 1) - 5;\n")
                generator_f.write("solutionArray[j] = random;\n")
            elif "FloatWritable" in T2:
                generator_f.write("float random = (int)(Math.random() * 10 + 1) - 5;\n")
                generator_f.write("solutionArray[j] = new FloatWritable(random);\n")
            elif "Float" in T2:
                generator_f.write("float random = (int)(Math.random() * 10 + 1) - 5;\n")
                generator_f.write("solutionArray[j] = random;\n")
        elif "REDUCER" in line:
            for line_r in reducer_f.readlines():
                generator_f.write(line_r)
        else:
            generator_f.write(line)

    wrapper_f.close()
    reducer_f.close()
    generator_f.close()

    result = os.popen("cd " + path + " && " + Mvn).readlines()
    if len(result) != 0:
        print "Compile Error"
        for line in result:
            line = line.replace("\n", "")
            if ("/home/" in line) and ("/.fields/" in line):
                parts = line.split(" ")
                del parts[1]
                line = ""
                for part in parts:
                    line = line + part + " "
                print line
            else:
                print line
        error_exit(path)


def parse_checker_output(filename):
    log = open(filename, "r")
    result = True
    hasResult = False
    for line in log.readlines():
        line = line.replace("\n", "")
        if "RESULT" in line:
            hasResult = True
            if "NOT" in line:
                result = False
            print line
            break

    if not hasResult:
        print "j-ReCoVer returned no result"

    log.close()
    return (hasResult & result)

def run_checker(global_path, path, p_name):
    target = path + "target/New-1.0.jar"
    filename = global_path + ".fields/" + p_name + "_checker"
    cmd = "java -jar -Xms2G -Xmx2G " + global_path + "j-recover.jar " + target + " autoGenerator -z " 
    proc = Popen(cmd, shell=True, stdout=PIPE, preexec_fn=os.setsid)
    result = wait_timeout(proc, TIMEOUT)

    return proc.communicate()[0]

def run_counter(global_path, path, p_name):
    target = path + "target/New-1.0.jar"
    filename = global_path + ".fields/" + p_name + "_checker"
    cmd = "java -jar -Xms2G -Xmx2G " + global_path + "j-recover.jar " + target + " autoGenerator -j " 
    proc = Popen(cmd, shell=True, stdout=PIPE, preexec_fn=os.setsid)

    res = proc.communicate()[0].splitlines()
    if_cnt = 0
    for line in res:
        if line.lstrip().startswith("if"):
            if_cnt += 1
    
    lv = res[-1].split(": ")[1]
    num_line = int(lv.split("/")[0])
    num_var = int(lv.split("/")[1])

    return num_line, num_var, if_cnt


def parse_finder_output(filename):
    log = open(filename, "r")
    data = ""
    full_log = ""
    count = 0
    for line in log.readlines():
        line = line.replace("\n", "")
        if "The reducer is" in line:
            count += 1
            if "Not" in line:
                print "RESULT: Counterexample found:"
                print data
                return
            else:
                full_log = full_log + data
                full_log = full_log + "--------\n"
                data = ""
        else:
            data = data + line + "\n"
    
    if count < 10:
        print "RESULT: Cannot find a counterexample from these testcases:"
        print full_log
    else:
        print "RESULT: Cannot find a counterexample in " + str(count) + " tests"
        print "Testcases were generated randomly."
        print ""
        print "Following are the first 50 lines of testcases:"
        i = 0
        for line in full_log.splitlines():
            if i >= 50:
                break
            else:
                i += 1
                print line
    log.close()

def run_finder(global_path, path, p_name):
    process = None
    filename = global_path + ".fields/" + p_name + "_finder"
    cmd = "java -jar " + path + "target/New-1.0.jar" + " > " + filename
    process = subprocess.Popen(cmd, shell=True, preexec_fn=os.setsid)
    result = wait_timeout(process, 10)

    if not result:
        print "RESULT: Finder timeout"
    else:
        parse_finder_output(filename)

    os.system("rm -rf " + filename)


def main(T1, T2, T3, T4, r_type):
    global_path = os.path.dirname(os.path.abspath(__file__)) + "/"
    p_name = str(int(time.time()) % 10000)
    os.system("mkdir -p " + global_path + ".fields")
    path = global_path + ".fields/" + p_name + "/"

    
    start = time.time()
    compile(T1, T2, T3, T4, r_type, global_path, path)
    end = time.time()
    c_time = round(end - start, 3)
    print("Compile: %s" % c_time)


    start = time.time()
    smt = run_checker(global_path, path, p_name)
    end = time.time()
    p_time = round(end - start, 3)
    print("Process: %s" % p_time)

    process = Popen("z3 -in", shell=True, stdin=PIPE, stdout=PIPE)
    start = time.time()
    out = process.communicate(input=smt.encode())[0]
    end = time.time()
    s_time = round(end - start, 3)
    print("Z3: %s" % s_time)

    total = c_time + p_time + s_time
    print("Total: %s" % round(total, 3))


    num_line, num_var, num_if = run_counter(global_path, path, p_name)
    print("Line: %s" % num_line)
    print("Var: %s" % num_var)
    print("If-: %s" % num_if)


    print("SMT: %s" % out.decode().splitlines()[0])

    os.system("rm -rf " + path)


if __name__ == "__main__":
    if (len(sys.argv) != 6) and (len(sys.argv) != 7) and (len(sys.argv) != 1) and (len(sys.argv) != 2):
        print "Usage: ./j-ReCoVer [T1 T2 T3 T4 reducer_type] [reducer file]"
        exit(1)
    
    if (len(sys.argv) == 6) or (len(sys.argv) == 7): 
        main(sys.argv[1], sys.argv[2], sys.argv[3], sys.argv[4], sys.argv[5])
    else:
        main(*get_type())


