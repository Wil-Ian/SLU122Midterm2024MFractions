public class fractionInner {

    private int numerator   = 0;
    private int denominator = 1;


    public fractionInner() {}
    public fractionInner(int numerator, int denominator) throws ZeroDenominatorException {
        if (denominator == 0) {
            throw new ZeroDenominatorException();
        }

        this.numerator = numerator;
        this.denominator = denominator;
    }

    //Prints the fraction to standard output
    public void display() {
        System.out.println(toString());
    }

     // @return String - stringified fraction

    @Override
    public String toString() {
        if (this.numerator >= this.denominator) {
            String returnString = String.valueOf(this.numerator / this.denominator);
            int modulo = (this.numerator % this.denominator);
            if (modulo > 0) {
                returnString += " " + modulo + "/" + this.denominator;
            }
            return returnString;
        }
        return this.numerator + "/" + this.denominator;
    }


     //Fraction multiplication.

     //@param f2 - Fraction to multiply with.

     //@return simplified Fraction result.

     //@throws ZeroDenominatorException if the operation (somehow) results in a zero denominator value.

    public fractionInner mul(fractionInner f2) throws ZeroDenominatorException {
        fractionInner result = new fractionInner(
                this.getNumerator() * f2.getNumerator(),
                this.getDenominator() * f2.getDenominator()
        );
        return result.simplify();
    }


     //Fraction division

     //@param f2 fraction to divide by.

     //@return simplified Fraction result.

     //@throws ZeroDenominatorException if the operation (somehow) results in a zero denominator value.

    public fractionInner div(fractionInner f2) throws ZeroDenominatorException {
        fractionInner result = new fractionInner(
                this.getDenominator() * f2.getNumerator(),
                this.getNumerator() * f2.getDenominator()
        );
        return result.simplify();
    }


     //Fraction addition.

     //@param f2 fraction to add.

     //@return simplified result fraction.

     //@throws ZeroDenominatorException if the operation (somehow) results in a zero denominator value.

    public fractionInner add(fractionInner f2) throws ZeroDenominatorException {
        fractionInner result = new fractionInner(
                (this.getNumerator() * f2.getDenominator() + f2.getNumerator() * this.getDenominator()),
                (this.getDenominator() * f2.getDenominator())
        );
        return result.simplify();
    }


     //@param f2 fraction to subtract.

     //@return simplified result fraction

     //@throws ZeroDenominatorException

    public fractionInner sub(fractionInner f2) throws ZeroDenominatorException {
        fractionInner result = new fractionInner(
                (this.getNumerator() * f2.getDenominator() - this.getDenominator() * f2.getNumerator()),
                (this.getDenominator() * f2.getDenominator())
        );
        return result.simplify();
    }

     //@return simplified fraction

     //@throws ZeroDenominatorException

    public fractionInner simplify() throws ZeroDenominatorException {
        int gcd = GCD(this.denominator, this.numerator);

        this.numerator = this.numerator / gcd;
        this.denominator = this.denominator / gcd;

        return this;
    }


     //GCD - Find greatest common denominator. (Recursive method call)

     //@param a First number
     //@param b Second number

     //@return greatest common denominator

    private int GCD(int a, int b) {
        if (b == 0) return Math.abs(a);
        return GCD(b, a % b);
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) throws ZeroDenominatorException {
        if (denominator <= 0) {
            throw new ZeroDenominatorException();
        }

        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }
}
