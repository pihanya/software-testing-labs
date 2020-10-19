package ru.itmo.anokhin.testing.lab2.utils;

import static java.util.Objects.requireNonNull;

import java.math.BigDecimal;
import ru.itmo.anokhin.testing.lab2.UnaryMathFunction;
import ru.itmo.anokhin.testing.lab2.logarithmic.Log2;
import ru.itmo.anokhin.testing.lab2.logarithmic.Log3;
import ru.itmo.anokhin.testing.lab2.logarithmic.Log5;
import ru.itmo.anokhin.testing.lab2.logarithmic.LogE;
import ru.itmo.anokhin.testing.lab2.logarithmic.LogN;
import ru.itmo.anokhin.testing.lab2.trigonomertic.Cos;
import ru.itmo.anokhin.testing.lab2.trigonomertic.Cosec;
import ru.itmo.anokhin.testing.lab2.trigonomertic.Sec;
import ru.itmo.anokhin.testing.lab2.trigonomertic.Sin;
import ru.itmo.anokhin.testing.lab2.trigonomertic.Tan;

@SuppressWarnings("unused")
public class MathFacade {

  private final LogE logE;

  private final Log2 log2;

  private final Log3 log3;

  private final Log5 log5;

  private final Sin sin;

  private final Cos cos;

  private final Tan tan;

  private final Cosec cosec;

  private final Sec sec;

  public MathFacade(final BigDecimal precision) {
    this.logE = new LogE(precision);
    this.log2 = new Log2(this.logE);
    this.log3 = new Log3(this.logE);
    this.log5 = new Log5(this.logE);

    this.sin = new Sin(precision);
    this.cos = new Cos(this.sin);
    this.tan = new Tan(this.sin, this.cos);
    this.cosec = new Cosec(this.sin);
    this.sec = new Sec(this.cos);
  }

  public MathFacade() {
    this(Constants.DEFAULT_PRECISION);
  }

  public MathFacade(
      final LogE logE, final Log2 log2, final Log3 log3, final Log5 log5,
      final Sin sin, final Cos cos, final Tan tan,
      final Cosec cosec, final Sec sec
  ) {
    this.logE = requireNonNull(logE);
    this.log2 = requireNonNull(log2);
    this.log3 = requireNonNull(log3);
    this.log5 = requireNonNull(log5);
    this.sin = requireNonNull(sin);
    this.cos = requireNonNull(cos);
    this.tan = requireNonNull(tan);
    this.cosec = requireNonNull(cosec);
    this.sec = requireNonNull(sec);
  }

  public UnaryMathFunction ln() {
    return this.logE;
  }

  public UnaryMathFunction log2() {
    return this.log2;
  }

  public UnaryMathFunction log3() {
    return this.log3;
  }

  public UnaryMathFunction log5() {
    return this.log5;
  }

  public UnaryMathFunction sin() {
    return this.sin;
  }

  public UnaryMathFunction cos() {
    return this.cos;
  }

  public UnaryMathFunction tan() {
    return this.tan;
  }

  public UnaryMathFunction cosec() {
    return this.cosec;
  }

  public UnaryMathFunction sec() {
    return this.sec;
  }

  public final double ln(final double x) {
    return ln().calculate(x);
  }

  public final BigDecimal ln(final BigDecimal x) {
    return ln().calculate(x);
  }

  public double logN(final double n, final double x) {
    return new LogN(logE, BigDecimal.valueOf(n)).calculate(x);
  }

  public BigDecimal logN(final BigDecimal n, final BigDecimal x) {
    return new LogN(logE, n).calculate(x);
  }

  public final double log2(final double x) {
    return log2().calculate(x);
  }

  public final BigDecimal log2(final BigDecimal x) {
    return log2().calculate(x);
  }

  public final double log3(final double x) {
    return log3().calculate(x);
  }

  public final BigDecimal log3(final BigDecimal x) {
    return log3().calculate(x);
  }

  public final double log5(final double x) {
    return log5().calculate(x);
  }

  public final BigDecimal log5(final BigDecimal x) {
    return log5().calculate(x);
  }

  public final double sin(final double x) {
    return sin().calculate(x);
  }

  public final BigDecimal sin(final BigDecimal x) {
    return sin().calculate(x);
  }

  public final double cos(final double x) {
    return cos().calculate(x);
  }

  public final BigDecimal cos(final BigDecimal x) {
    return cos().calculate(x);
  }

  public final double tan(final double x) {
    return tan().calculate(x);
  }

  public final BigDecimal tan(final BigDecimal x) {
    return tan().calculate(x);
  }

  public final double cosec(final double x) {
    return cosec().calculate(x);
  }

  public final BigDecimal cosec(final BigDecimal x) {
    return cosec().calculate(x);
  }

  public final double sec(final double x) {
    return sec().calculate(x);
  }

  public final BigDecimal sec(final BigDecimal x) {
    return sec().calculate(x);
  }
}
