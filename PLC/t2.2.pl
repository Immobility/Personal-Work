$a = 1;

sub sub1 {
  return $a;
}

sub static {
  my $a = 2;
  return sub1();
}

$b = 3;

sub sub2 {
  return $b;
}

sub dynamic {
  local $b = 4;
  return sub2();
}

print "Static: ", static(), "\n";

print "Dynamic: ", dynamic()";
