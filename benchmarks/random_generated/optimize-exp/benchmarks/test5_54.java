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
a019 -= a000;
a012 = a022 - a005;
a004 = a003 + a006;
a019 = a011 + a016;
a024 = a020 - a000;
a011 = 4 - a002;
a014 += a006;
a023 = a004 - a004;
a020 -= a024;
a022 -= a024;
if (a024 <= a003) {
cur = a007 - a009;
a011 = -5 - a017;
a004 -= a016;
a024 = a022 - a016;
a007 = a006 - a024;
a018 -= a011;
} else {
cur = a008 - a005;
a001 -= a004;
a021 = a012 - a015;
a018 = -5 - a006;
a003 += a024;
a023 = a001 + a007;
a017 = a018 + -2;
a015 -= a017;
a006 -= a006;
a023 = a007 + a019;
a006 = a002 - a013;
a014 = a014 + 1;
a024 = a006 + a012;
a000 = a024 + a000;
a008 -= a015;
a010 = -5 + a022;
a009 -= a009;
cur -= a004;
a013 -= a016;
a001 = a024 - a009;
a006 = a001 - a014;
a003 -= a004;
a005 -= a008;
a015 = a005 - a018;
a006 -= a005;
}
a005 = a020 - a004;
a012 -= a011;
a019 += a007;
a001 += a017;
a001 -= a016;
a011 -= a017;
a009 += a010;
a012 -= a009;
a008 = a010 - a016;
a016 = a014 - a007;
cur += a010;
a005 = a021 + a014;
a005 = a011 - a013;
a000 = 3 + a015;
a021 = a010 + a010;
a001 += a000;
cur = a003 - a001;
a015 -= a024;
a021 -= a023;
a015 -= a003;
a012 = a001 + a015;
a000 = a009 + a011;
a006 = cur + a000;
if (a009 > a019) {
a020 = a015 - a000;
a016 -= a022;
a020 += a009;
a014 = a008 - cur;
a018 += a024;
a014 = a002 + a024;
a002 -= a017;
a005 = a005 - a021;
a020 += a022;
a004 += a017;
a024 = a014 + a013;
a001 = a019 + a021;
a003 += a010;
a010 -= a005;
a015 = a010 + a018;
a014 = a011 - a014;
a008 -= a010;
a019 += a017;
} else {
a012 += cur;
a013 = a006 - a006;
a000 = a008 - a015;
cur = a002 - cur;
a009 = a013 - a015;
a023 += a007;
a002 -= a011;
a009 += a014;
a021 = a009 - a000;
a005 = a023 + a018;
a018 -= a004;
a007 = a001 - cur;
a013 += a012;
a024 += a023;
a010 = a014 - a023;
a024 += a018;
a001 = a006 - a024;
a012 = a000 + a021;
a020 += a004;
a011 = cur - a020;
cur += a011;
a000 = a019 - a007;
if (a014 > 1) {
a008 = a002 + a021;
a004 -= a000;
a000 = a008 + 2;
a017 = a002 + a010;
a019 -= a023;
a021 -= a022;
a002 = a006 + a017;
a010 -= a022;
a000 = 1 - a007;
a021 -= cur;
a001 = a020 - a008;
a007 = a010 - a015;
a001 = 2 - a023;
a016 = a018 + a016;
a023 += a005;
a005 = a007 - a008;
a010 += a017;
a016 -= a000;
cur -= a020;
a018 = a005 + a001;
a024 -= a005;
a004 = a017 - a006;
a002 = a004 - a007;
a009 = a013 - a022;
a005 = a009 + a006;
a002 -= a009;
a017 += a014;
if (a020 > a009) {
a024 = -5 + cur;
a019 -= a004;
a014 = a020 * -4;
a018 = a008 - a017;
a002 = a004 + a021;
} else {
a021 = a012 + a013;
cur += a017;
a008 += cur;
a001 += a012;
a004 += a009;
a022 = cur - 2;
a024 = a021 + a006;
a013 -= a006;
a011 = 1 + a011;
if (a001 != a019) {
a019 -= a014;
a005 = a016 - a024;
a017 = a000 + a015;
a004 = 0 + a014;
a020 = a008 - a024;
a016 -= a019;
a002 -= a008;
a005 = cur - a011;
a016 = a017 - a007;
a015 = a006 + a019;
a024 = a006 - a019;
a011 += a004;
a011 += a015;
a010 = a003 + a012;
a005 = a011 - a002;
a013 += a001;
a020 = a008 - a015;
a011 = a011 + a012;
a024 += a001;
a022 -= a008;
a022 -= a015;
a000 -= a000;
} else {
a005 = a009 + a008;
a020 = a014 + a023;
a016 += a009;
a006 = a002 - a010;
a013 = 2 + a022;
a021 += a018;
a009 = a009 - a006;
a002 -= a024;
a003 += a009;
a001 = a010 + a014;
}
a022 += a014;
a022 = a018 - a024;
a004 = a010 - a021;
a011 -= a004;
cur = a002 + a011;
a017 -= a012;
a009 += a008;
a003 -= a016;
a008 += a020;
a021 -= a017;
a011 -= a009;
a002 -= a014;
a018 = a004 + a017;
a007 = -5 + a004;
a019 = a017 - a000;
a019 -= a014;
a008 -= a012;
a002 -= a011;
a011 = a022 - cur;
a013 -= a000;
a018 -= a006;
a000 += a007;
a017 -= a001;
a021 += a015;
a001 = cur - a020;
a005 = a020 - a001;
a019 = a010 - a012;
a004 = a016 + a008;
}
a023 += a022;
a003 = a017 + a001;
a000 -= a020;
a000 -= a011;
a021 = a005 - a000;
a023 += a007;
} else {
a007 = a022 + a007;
a014 -= a023;
a020 = cur - a021;
a001 = a016 + a009;
a023 = a019 + a012;
a023 += a020;
a013 -= a003;
a019 = a007 + a000;
cur -= a010;
a018 = a022 - a016;
a012 -= -3;
a012 += a014;
a007 = a005 - a015;
a000 += a021;
a013 = a010 + a014;
a012 = a012 + a020;
a011 -= a001;
a016 -= a003;
a017 = a008 + a020;
a015 -= a016;
a017 = a001 + a021;
a022 = a021 + a019;
a004 += cur;
a001 = a009 - -2;
a006 = a006 + a024;
a015 -= a009;
a005 += a014;
a002 += a023;
a011 = a007 - a023;
a014 = a023 - a008;
}
a002 += a002;
a002 += cur;
a005 = a000 + a023;
a008 -= a022;
}
a007 += a005;
a015 = a014 + a006;
cur -= a017;
a013 = -2 + a003;
a022 = a016 + cur;
}
output.collect(prefix, new IntWritable(a012));
}
