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
a018 += a002;
a002 = a006 - cur;
a006 -= cur;
a023 = a019 - a006;
a014 -= a012;
a011 = a020 + a011;
cur -= a008;
a018 -= a011;
a019 -= a005;
a020 = cur - a012;
a000 -= a023;
a012 = a023 - a018;
a004 = a001 - a002;
a004 = a010 - a007;
if (a021 != a007) {
a016 = a011 + a014;
a008 = a003 - a002;
a024 += a003;
} else {
a017 += a000;
a000 -= a011;
a004 = a016 - a014;
a009 = a012 + a008;
a012 = a000 - a021;
if (a010 != a024) {
a005 = a000 + a003;
a008 += a021;
a004 += a013;
a012 = a014 + a014;
a008 += a000;
a001 = a021 + a018;
a010 = a023 + a019;
a008 -= a000;
a015 -= a001;
a000 = 4 + a023;
a020 -= cur;
a001 = a011 - a018;
cur = a000 - 1;
a002 = a011 * -4;
a003 += a016;
a020 -= a016;
a023 = a005 - a001;
a003 = a005 - a019;
a006 = a004 - -4;
a014 = a001 - a006;
a014 = a014 - a022;
a002 -= a008;
a006 = a002 - a000;
if (a017 != a020) {
a013 = a019 - a007;
a001 = a004 + a002;
a007 = a016 + a012;
a013 = a015 - a005;
a022 = a021 - a007;
a013 = a004 + a010;
a018 = a006 + a019;
a001 = a020 - a005;
a007 = a015 + a008;
a000 += -4;
a010 -= a022;
cur = a016 - a016;
a022 = a018 + a016;
cur += a002;
cur = a022 - a016;
a018 += a015;
} else {
a006 -= a003;
a007 = a014 + -2;
cur += a020;
a018 += a009;
a021 += a011;
a021 = a009 + a015;
a016 = a005 + a000;
a003 += a017;
a017 = a009 + a013;
a020 -= a004;
a005 = a020 + a008;
a002 -= a001;
a000 = a024 + a022;
}
a010 -= a018;
a022 = a002 + a024;
a002 = a017 + a007;
a000 -= a019;
a015 += 3;
} else {
a010 += a016;
a010 -= a024;
a017 = a006 - a024;
a016 = a015 - -2;
a012 = a023 + a008;
a002 = a017 - a017;
a004 = a022 - a010;
cur += a004;
a004 += a003;
a002 = a021 - a008;
a019 += a024;
if (a002 >= a010) {
cur = a022 - a003;
a021 = a008 - a021;
a005 = a005 + a004;
a021 = a000 - a014;
a017 = cur + a020;
a014 = a006 - a012;
a019 -= a020;
if (a004 != a015) {
a023 += a005;
a011 += -1;
a009 = a014 + a017;
a000 -= a003;
a019 += a013;
a017 = a007 + 4;
a017 = a021 + a018;
a021 -= a024;
a000 = a005 + -3;
a018 = a017 + a004;
a014 -= a000;
a007 = a003 - a011;
a005 -= a018;
a017 -= a006;
a002 = a010 + a024;
a002 += cur;
a007 = a014 - a022;
a013 += a015;
a005 = a014 - cur;
a021 += a002;
} else {
a007 = a008 + -1;
a007 -= a011;
a010 += a010;
a024 = a002 - a020;
a022 -= a009;
a011 -= a001;
a018 -= a006;
a000 = a015 - a004;
a007 -= a017;
a014 = cur - 1;
a011 += cur;
a002 -= a019;
a024 = a024 - a002;
a002 += a015;
a001 = a005 + a022;
a001 = a013 - a024;
a024 = cur + a005;
a010 = a019 + a001;
a011 = a024 - a016;
a011 -= a006;
a000 = a005 + a022;
}
a007 = a020 + a002;
a006 = a023 - a003;
a018 = a005 + a021;
cur = a006 - a019;
} else {
a008 = a022 - a009;
a002 -= a006;
a020 -= a014;
a012 = -1 + a004;
a015 -= a012;
a001 = a022 + a007;
a017 += a011;
a002 += a021;
a004 = a018 + a004;
a019 -= a021;
a020 = cur + a017;
a014 = a006 + a014;
a011 += a021;
}
a013 = a001 + a018;
a010 -= a019;
a009 -= a019;
a024 -= a013;
a009 = a014 + a019;
a021 = a022 - a015;
a010 = cur + a014;
a012 -= a016;
a019 += a001;
a024 += a011;
a006 -= a013;
a012 -= a006;
cur = a015 - 2;
a007 = a006 + -5;
a013 -= a013;
a019 = a001 - a005;
a003 -= a023;
a011 -= a019;
a001 += a021;
a003 -= a006;
a024 = a020 + a006;
a015 += a019;
}
}
a003 = a019 + a008;
a021 = a016 + a009;
a002 = a003 + a015;
a014 += a000;
a003 = a023 + -5;
a009 = a018 + a019;
a007 = a004 + -2;
a007 = a004 + a010;
a002 = a009 - a006;
a011 = a007 - a001;
a008 = a012 - a008;
a004 -= a011;
a016 += cur;
a022 -= a021;
a001 += a007;
a010 -= 2;
a001 = a018 + a003;
a016 -= a014;
a016 += a017;
a000 = a001 + a022;
a003 = a005 - a020;
a017 = a023 + -2;
a014 = a014 + a016;
a006 += a021;
a018 = a023 + a016;
a017 = a007 - a007;
a010 -= a013;
a013 = a020 - a003;
a015 = a001 + a019;
a002 = a005 + a021;
a002 += a023;
a014 = -4 - a014;
a005 = a001 - a009;
a003 += a006;
a001 += a004;
a004 = a005 + a000;
a002 -= a011;
a009 = a022 - a000;
a023 = a013 - a005;
a010 = a013 - a000;
a024 = a020 + a011;
a005 = a020 + a020;
a007 = -3 + a015;
a010 -= a020;
a006 = a004 - a024;
a012 = a003 - a021;
a019 = a023 + a021;
a020 += a002;
a015 += a022;
a013 = a009 - a003;
a023 = a016 - a016;
a023 = a012 + a018;
a000 += a002;
a010 += a016;
a000 += a003;
a003 = a019 + a006;
a000 = a018 - a023;
a021 = a015 - a019;
a008 = a003 - a019;
a024 = a005 + a003;
a006 += a020;
a008 -= a007;
a024 += a005;
a001 = a017 + a016;
a008 += a009;
a000 += a022;
a021 = a020 * 4;
a003 = a017 + a013;
a017 += -3;
a006 -= a010;
a018 += a009;
a014 -= a021;
a005 = a024 - a005;
}
output.collect(prefix, new IntWritable(a004));
}
