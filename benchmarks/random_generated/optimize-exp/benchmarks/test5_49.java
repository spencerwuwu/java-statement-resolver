// Note: only +, - operations
// Parameters:
//   Variables:   25
//   Baselines:   250
//   If-Branches: 5

public void reduce(Text prefix, Iterator<IntWritable> iter,
         OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
int a000 = 0;
int a001 = 0;
int a002 = 0;
int a003 = 0;
int a004 = 0;
int a005 = 0;
int a006 = 0;
int a007 = 0;
int a008 = 0;
int a009 = 0;
int a010 = 0;
int a011 = 0;
int a012 = 0;
int a013 = 0;
int a014 = 0;
int a015 = 0;
int a016 = 0;
int a017 = 0;
int a018 = 0;
int a019 = 0;
int a020 = 0;
int a021 = 0;
int a022 = 0;
int a023 = 0;
int a024 = 0;
int cur = 0;

while (iter.hasNext()) {
cur = iter.next().get();
a006 = a003 - a017;
a016 -= a007;
a006 -= a014;
a013 = cur - a006;
a022 = a011 + a007;
a011 = a002 + a016;
cur = a009 - a006;
a021 = a013 + cur;
a002 = a022 + a021;
a014 -= cur;
a012 -= a024;
a024 = a014 + cur;
a011 = a021 - a005;
a016 = a014 - a005;
a010 -= a017;
a015 = a009 + a021;
a006 = a002 + 4;
a002 = a004 + a003;
a016 = a001 + a015;
a001 -= a019;
a005 += a008;
a008 = a017 - a008;
a011 = a008 + a020;
if (a011 == a018) {
a015 -= 3;
a008 = a022 - cur;
a005 = a002 - a018;
a010 = a021 - a003;
a019 -= a021;
a004 = a020 + a010;
a012 = a005 - a019;
a010 = a014 - a017;
a010 = a009 - a023;
a014 += a010;
a019 = a004 - a016;
a005 += a006;
a001 += a009;
a003 = a003 - a015;
a021 = a020 - a016;
a013 = a015 + a022;
a014 = a018 + a004;
a002 = a015 - a009;
a008 += cur;
a020 = a015 + a006;
a013 += a024;
a010 = a002 - a022;
a024 = a005 * -2;
} else {
a018 += a016;
a024 -= a017;
a013 += a001;
a019 = a014 - a010;
a019 = a018 - a002;
a014 = a016 + a004;
a017 -= a002;
a013 = a023 + a003;
a001 = a010 + a013;
a024 -= a011;
a017 = a002 + a011;
a013 -= a011;
a001 += a024;
cur += a012;
cur += a016;
a012 -= a016;
a003 -= a015;
a004 = a001 + a011;
a006 += a020;
a017 = a015 - a024;
a018 = a007 + a011;
a011 = a023 - a011;
a010 += a001;
a015 -= cur;
cur += a012;
a020 = a017 - a009;
a002 += a020;
a014 -= cur;
a006 = a006 - a022;
a013 = a009 - 3;
a013 = a006 + a001;
a010 = a007 - a021;
}
a013 = a022 + a003;
a006 -= a003;
a002 += a003;
a015 = a007 - cur;
a024 += a004;
a009 = a000 + a022;
a005 += a017;
a018 += a013;
a007 += a017;
a015 -= a012;
a024 = a015 + a015;
a024 -= a015;
a013 += a019;
a013 += a019;
a016 = a020 - a012;
a017 = a000 + -5;
a011 = a004 - a016;
a000 -= a020;
a016 = a000 - a019;
a004 = a011 + a022;
a017 = a021 - a016;
a023 = a004 + a012;
a002 -= a006;
a004 += a020;
a011 += a021;
a006 -= a006;
if (a009 < a020) {
a020 = a013 - a003;
a008 -= a022;
a003 += a015;
a003 = a006 + cur;
a010 -= a010;
a022 = a012 + a022;
a024 = a002 - a009;
a002 += a019;
a002 = a002 - a004;
a013 -= a015;
a002 -= a020;
cur = a024 - a010;
a012 += a012;
a006 -= a022;
a011 += cur;
a016 = a009 - a001;
a012 = a010 + a007;
a016 = a015 + a016;
a022 += cur;
a002 = a000 + a017;
a008 += a017;
a018 = a009 - a004;
cur -= a019;
} else {
a023 -= a022;
a023 += a002;
a003 = a011 - 2;
a008 = a015 + a002;
a005 = a007 + a011;
a013 = cur - a013;
a023 = a018 + a024;
a021 = a014 - a008;
a009 = a015 + a003;
a002 = a005 - a018;
a024 -= a011;
a009 = a000 + a002;
cur -= a012;
if (a012 >= a009) {
a007 += a009;
a003 = a021 - a023;
if (a019 > 1) {
a013 = a002 + a014;
a010 = a008 - a014;
a015 += a005;
a024 = a024 - a020;
a007 += a024;
a013 -= a010;
a021 = a002 - a004;
a016 = a003 + a017;
a024 = a023 + a008;
a002 -= a016;
a015 = 1 + a019;
a020 -= a007;
a014 = a006 - a015;
a005 += a011;
a003 -= a016;
a004 -= cur;
a021 = a023 - a014;
a017 = a012 - a023;
a012 += a001;
a012 += a022;
a006 = a017 - a013;
cur -= a024;
a023 = a016 - a004;
a000 = a011 + a001;
a005 -= 1;
a005 -= a002;
a014 = a007 + a019;
} else {
a023 = a017 + 0;
a003 -= a002;
a000 = a013 - a004;
a022 -= a024;
a024 = a009 + a014;
a022 += a008;
a002 = a013 - a007;
cur = a013 + a017;
a010 = a010 + a012;
a016 = a007 + a006;
a001 -= a008;
a007 += a017;
a017 += a000;
a000 -= a010;
a018 += a000;
a001 += a005;
a006 = a006 + a003;
a006 = a002 + a003;
a007 += cur;
a000 -= a021;
a008 += a008;
a010 -= a016;
cur += a016;
a002 = a008 - a024;
a017 = a012 + a020;
a007 = a021 + a012;
a012 += a000;
a004 = a013 - a001;
a005 = a003 + a018;
a006 = a018 - a012;
a013 = a001 + a019;
a023 = a023 - a020;
a007 = a013 - a017;
}
a023 += a004;
a017 += 0;
a024 = a017 - a008;
a022 += a000;
a015 += a019;
a017 = cur - a005;
a005 += a004;
a011 = a006 + a012;
a012 = a012 + a009;
a013 += a004;
a002 = a023 + a000;
a004 = a011 + a005;
a014 += a010;
a023 = a014 + a010;
a017 = a012 - a010;
a023 = a008 + a013;
} else {
a016 += a024;
a000 += a004;
a024 = a015 + a006;
a012 = a008 - a010;
a008 = a024 + a021;
}
a016 += a018;
a006 = cur + a008;
a012 = cur + a002;
a001 -= a017;
a001 -= a003;
a019 += a013;
a023 -= a013;
a008 = a015 + a010;
a015 -= a021;
a004 = a007 + a024;
a015 += a020;
a013 = a021 + a024;
a007 = a019 + a017;
a005 += a020;
a006 -= a006;
a022 = cur + 3;
a022 = a013 - a009;
a011 = a014 + a020;
a000 += a014;
a018 = a012 + a006;
a003 = a021 + a019;
if (a023 < a006) {
a002 += a021;
a007 -= a020;
a021 -= a018;
} else {
a021 += a024;
a002 -= a014;
}
}
a015 = a018 + a007;
}
output.collect(prefix, new IntWritable(a014));
}