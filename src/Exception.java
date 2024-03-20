class ZeroDenominatorException extends Exception {

    ZeroDenominatorException() {
        super("fraction denominator cannot be 0.");
    }
}
