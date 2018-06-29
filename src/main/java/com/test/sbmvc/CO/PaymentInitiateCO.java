package com.test.sbmvc.CO;

public class PaymentInitiateCO {
    private double transactionValue;

    private String standingInstructionYN;

    public String getStandingInstructionYN() {
        return standingInstructionYN;
    }

    public void setStandingInstructionYN(String standingInstructionYN) {
        this.standingInstructionYN = standingInstructionYN;
    }

    public double getTransactionValue() {
        return transactionValue;
    }

    public void setTransactionValue(double transactionValue) {
        this.transactionValue = transactionValue;
    }

    @Override
    public String toString() {
        return "PaymentInitiateCO{" +
                "transactionValue=" + transactionValue +"standingInstructionYN= "+standingInstructionYN+
                "}";
    }
}
