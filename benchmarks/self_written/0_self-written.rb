Testcase.create(:name => "basic_MAD1.java", :java => "// basic - Mean Absolute Deviation part1\n// Calculate the average\n// Cont. in part 2\n\npublic void reduce(Text key, Iterator<IntWritable> iter,\n        OutputCollector<Text, DoubleWritable> output, Reporter reporter) throws IOException {\n    int cnt = 0;\n    double sum = iter.next().get();\n\n    while(iter.hasNext()) {\n        int cur = iter.next().get();\n        sum += cur;\n        cnt += 1;\n    }\n\n    output.collect(key, new DoubleWritable(sum / cnt));\n}\n\n", :t1 => "Text", :t2 => "IntWritable", :t3 => "Text", :t4 => "DoubleWritable", :r_type => "Collector", :source => "2018", :comment => "", :result_type => 1, :result => "Proved to be commutative.")
Testcase.create(:name => "basic_sep.java", :java => "// basic - sep\n\npublic void reduce(Text key, Iterator<IntWritable> iter,\n        OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {\n    int ret = 0;\n\n    while(iter.hasNext()) {\n        int cur = iter.next().get();\n\n        if (cur % 2 == 0) ret += 1;\n        else ret -= 1;\n    }\n\n    output.collect(key, new IntWritable(ret));\n}\n\n", :t1 => "Text", :t2 => "IntWritable", :t3 => "Text", :t4 => "IntWritable", :r_type => "Collector", :source => "2018", :comment => "", :result_type => 1, :result => "Proved to be commutative.")
Testcase.create(:name => "basic_max.java", :java => "// basic - max\n\npublic void reduce(Text key, Iterator<IntWritable> iter,\n        OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {\n    int ret = iter.next().get();\n\n    while(iter.hasNext()) {\n        int cur = iter.next().get();\n        ret = ret < cur ? cur : ret;\n    }\n\n    output.collect(key, new IntWritable(ret));\n}\n", :t1 => "Text", :t2 => "IntWritable", :t3 => "Text", :t4 => "IntWritable", :r_type => "Collector", :source => "2018", :comment => "", :result_type => 1, :result => "Proved to be commutative.")
Testcase.create(:name => "range.java", :java => "// Find the range of the values\n\npublic void reduce(Text prefix, Iterator<IntWritable> iter,\n        OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {\n    int cur = iter.next().get();\n    int max = cur;\n    int min = cur;\n    while(iter.hasNext()) {\n        cur = iter.next().get();\n        max = cur > max ? cur : max;\n        min = cur < min ? cur : min;\n    }\n    output.collect(prefix, new IntWritable(max - min));\n}\n", :t1 => "Text", :t2 => "IntWritable", :t3 => "Text", :t4 => "IntWritable", :r_type => "Collector", :source => "2018", :comment => "", :result_type => 1, :result => "Proved to be commutative.")
Testcase.create(:name => "basic_avg.java", :java => "// basic - avg\n\npublic void reduce(Text key, Iterator<IntWritable> iter,\n        OutputCollector<Text, DoubleWritable> output, Reporter reporter) throws IOException {\n    int ret = 0;\n    int cnt = 0;\n\n    while(iter.hasNext()) {\n        int cur = iter.next().get();\n        ret += cur;\n        cnt += 1;\n    }\n\n    output.collect(key, new DoubleWritable(ret / cnt));\n}\n\n", :t1 => "Text", :t2 => "IntWritable", :t3 => "Text", :t4 => "DoubleWritable", :r_type => "Collector", :source => "2018", :comment => "", :result_type => 1, :result => "Proved to be commutative.")
Testcase.create(:name => "tricky_avg.java", :java => "// \n\npublic void reduce(Text key, Iterator<IntWritable> values, \n        OutputCollector<Text, DoubleWritable> output, Reporter reporter) throws IOException {\n    double avg = 0;\n    int sum1 = 0;\n    int count1 = 0;\n    int sum2 = 0;\n    int count2 = 0;\n    int sum3 = 0;\n    int count3 = 0;\n\n    while(values.hasNext()){\n        int cur = values.next().get();\n        if (cur < 10) {\n            sum1 += cur;\n            count1 += 1;\n        } else if (cur >= 20) {\n            sum3 += cur;\n            count3 += 1;\n        } else {\n            sum2 += cur;\n            count2 += 1;\n        }\n    }\n    avg = (sum1 + sum2 + sum3) / (count1 + count2 + count3);\n\n    output.collect(key, new DoubleWritable(avg));\n}\n", :t1 => "Text", :t2 => "IntWritable", :t3 => "Text", :t4 => "DoubleWritable", :r_type => "Collector", :source => "2018", :comment => "", :result_type => 1, :result => "Proved to be commutative.")
Testcase.create(:name => "basic_MAD2.java", :java => "// basic - Mean Absolute Deviation part2\n// Avarge calculated in part1, use random value here\n\npublic void reduce(Text key, Iterator<IntWritable> iter,\n        OutputCollector<Text, DoubleWritable> output, Reporter reporter) throws IOException {\n    int cnt = 0;\n    int mad = 0;\n    double avg = (double)(Math.random() * 1000 + 1) - 500;\n\n    while(iter.hasNext()) {\n        int cur = iter.next().get();\n\n        if (cur < avg) mad += avg - cur;\n        else mad += cur - avg;\n    }\n\n    output.collect(key, new DoubleWritable(mad / cnt));\n}\n\n", :t1 => "Text", :t2 => "IntWritable", :t3 => "Text", :t4 => "DoubleWritable", :r_type => "Collector", :source => "2018", :comment => "", :result_type => 1, :result => "Proved to be commutative.")
Testcase.create(:name => "max_even_odd.java", :java => "// Sum up the odd and even numbers in the list\n// Return the bigger one\n// Not commutable\n\npublic void reduce(Text prefix, Iterator<IntWritable> iter,\n        OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {\n    int sumEven = 0;\n    int sumOdd = 0;\n    int index = 0;\n\n    while(iter.hasNext()) {\n        int cur = iter.next().get();\n        if (index % 2 == 0) sumEven += cur;\n        else sumOdd += cur;\n        index += 1;\n    }\n\n    output.collect(prefix, new IntWritable(sumEven > sumOdd ? sumEven : sumOdd));\n}\n\n", :t1 => "Text", :t2 => "IntWritable", :t3 => "Text", :t4 => "IntWritable", :r_type => "Collector", :source => "2018", :comment => "", :result_type => 2, :result => "CANNOT prove to be commutative. Counterexample found. ")
Testcase.create(:name => "basic_dis.java", :java => "// basic - dis\n\npublic void reduce(Text key, Iterator<IntWritable> iter,\n        OutputCollector<Text, DoubleWritable> output, Reporter reporter) throws IOException {\n    int ret = 0;\n    int cnt = 0;\n\n    while(iter.hasNext()) {\n        int cur = iter.next().get();\n\n        if (cur > 100) {\n            ret += cur;\n            cnt += 1;\n        }\n    }\n\n    if (cnt != 0)\n        output.collect(key, new DoubleWritable(ret / cnt));\n    else\n        output.collect(key, new DoubleWritable(0));\n}\n", :t1 => "Text", :t2 => "IntWritable", :t3 => "Text", :t4 => "DoubleWritable", :r_type => "Collector", :source => "2018", :comment => "", :result_type => 1, :result => "Proved to be commutative.")
Testcase.create(:name => "basic_sum.java", :java => "// basic - sum\n\npublic void reduce(Text key, Iterator<IntWritable> iter,\n        OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {\n    int ret = 0;\n\n    while(iter.hasNext()) {\n        int cur = iter.next().get();\n        ret += cur;\n    }\n\n    output.collect(key, new IntWritable(ret));\n}\n", :t1 => "Text", :t2 => "IntWritable", :t3 => "Text", :t4 => "IntWritable", :r_type => "Collector", :source => "2018", :comment => "", :result_type => 1, :result => "Proved to be commutative.")
Testcase.create(:name => "tcp_waittime.java", :java => "// Idea comes from the TCP back up inverval\n\npublic void reduce(Text key, Iterator<IntWritable> values, \n        OutputCollector<Text, Integer> output, Reporter reporter) throws IOException {\n\n    int cur = values.next().get();\n    int maxEdge = cur * 2;\n\n    while(values.hasNext()){\n        int in = values.next().get();\n        if (cur + in > maxEdge) {\n            maxEdge = maxEdge * 2;\n            cur = 0;\n        } else {\n            cur += in;\n        }\n    }\n\n    output.collect(key, cur);\n}\n", :t1 => "Text", :t2 => "IntWritable", :t3 => "Text", :t4 => "Integer", :r_type => "Collector", :source => "2018", :comment => "", :result_type => 2, :result => "CANNOT prove to be commutative. Counterexample found. ")
Testcase.create(:name => "basic_SD.java", :java => "// basic - Standard Deviation\n\npublic void reduce(Text key, Iterator<DoubleWritable> values, \n        OutputCollector<Text, DoubleWritable> output, Reporter reporter) throws IOException {\n    double stdDev = 0;\n    double sumSqr = 0;\n    double count = 0;\n    double mean = 0;\n    double sum = 0;\n    while(values.hasNext()){\n        double value = values.next().get();\n        sumSqr += value * value;\n        sum += value;\n        count++;\n    }\n    mean = sum / count;\n    stdDev = Math.sqrt((sumSqr - count * mean * mean) / count);\n    output.collect(key, new DoubleWritable(stdDev));\n}\n", :t1 => "Text", :t2 => "DoubleWritable", :t3 => "Text", :t4 => "DoubleWritable", :r_type => "Collector", :source => "2018", :comment => "", :result_type => 1, :result => "Proved to be commutative.")
Testcase.create(:name => "deep_branches.java", :java => "// A program with complicate condition branches\n// Just making it hard to determine commutativity in one sight\n//\n// Counter Example:\n//  Input1: [3, 2, 3, 1]\n//  Input2: [1, 3, 2, 3]\n//  Output1: [20]\n//  Output2: [6]\n\npublic void reduce(Text prefix, Iterator<IntWritable> iter,\n        OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {\n    int cur = iter.next().get();\n    int max = cur;\n    int min = cur;\n    int sum1 = 0;\n    int sum2 = 0;\n    while(iter.hasNext()) {\n        cur = iter.next().get();\n        max = cur > max ? cur : max;\n        min = cur < min ? cur : min;\n        if (max > 10) {\n            if (sum1 == 3) {\n                sum1 -= cur;\n                max += 1;\n                sum2 = min + max;\n            } else {\n                if (sum1 + min == 3) {\n                    sum2 += cur;\n                    max *= 3;\n                } else {\n                    min = 0;\n                    if (sum2++ > sum1) {\n                        sum1 = sum2 + max + min;\n                    }\n                }\n                min -= max;\n                sum2 -= 1;\n            }\n        } else {\n            if (sum1 == 3) {\n                sum1 -= cur;\n                sum2 += cur;\n            } else {\n                if (sum1 + min == 3) {\n                    max *= 3;\n                    sum2 = min + max;\n                    max += 1;\n                } else {\n                    min = 0;\n                    if (sum2++ > sum1) {\n                        sum1 = sum2 + max + min;\n                    }\n                }\n                min += max;\n                sum2 /= 2;\n            }\n        }\n    }\n    output.collect(prefix, new IntWritable(sum1 + sum2));\n}\n\n", :t1 => "Text", :t2 => "IntWritable", :t3 => "Text", :t4 => "IntWritable", :r_type => "Collector", :source => "2018", :comment => "", :result_type => 2, :result => "CANNOT prove to be commutative. Counterexample found. ")
Testcase.create(:name => "basic_rangesum.java", :java => "// basic - rangesum\n\npublic void reduce(Text key, Iterator<IntWritable> iter,\n        OutputCollector<Text, DoubleWritable> output, Reporter reporter) throws IOException {\n    int ret = 0;\n    int cnt = 0;\n\n    while(iter.hasNext()) {\n        int cur = iter.next().get();\n\n        if (cnt > 4) {\n            ret += cur;\n        }\n        cnt += 1;\n    }\n\n    if (cnt != 0)\n        output.collect(key, new DoubleWritable(ret / cnt));\n    else\n        output.collect(key, new DoubleWritable(0));\n}\n", :t1 => "Text", :t2 => "IntWritable", :t3 => "Text", :t4 => "DoubleWritable", :r_type => "Collector", :source => "2018", :comment => "", :result_type => 3, :result => "Proved to be commutative. Counterexample found. ")
puts "Self-written benchmarks done"