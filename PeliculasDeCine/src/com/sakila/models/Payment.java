package com.sakila.models;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Representa un pago realizado por un cliente en el sistema Sakila.
 */
public class Payment {

    /** ID único del pago. */
    private int paymentId;

    /** ID del cliente que realiza el pago. */
    private int customerId;

    /** ID del empleado que procesa el pago. */
    private int staffId;

    /** ID de la renta asociada a este pago. */
    private int rentalId;

    /** Monto del pago. */
    private BigDecimal amount;

    /** Fecha en la que se realizó el pago. */
    private Timestamp paymentDate;

    /**
     * Constructor completo de la clase Payment.
     *
     * @param paymentId ID del pago
     * @param customerId ID del cliente
     * @param staffId ID del empleado
     * @param rentalId ID de la renta
     * @param amount Monto pagado
     * @param paymentDate Fecha del pago
     */
    public Payment(int paymentId, int customerId, int staffId, int rentalId, BigDecimal amount, Timestamp paymentDate) {
        this.paymentId = paymentId;
        this.customerId = customerId;
        this.staffId = staffId;
        this.rentalId = rentalId;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    /** @return ID del pago */
    public int getPaymentId() { return paymentId; }

    /** @param paymentId ID del pago */
    public void setPaymentId(int paymentId) { this.paymentId = paymentId; }

    /** @return ID del cliente */
    public int getCustomerId() { return customerId; }

    /** @param customerId ID del cliente */
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    /** @return ID del empleado */
    public int getStaffId() { return staffId; }

    /** @param staffId ID del empleado */
    public void setStaffId(int staffId) { this.staffId = staffId; }

    /** @return ID de la renta asociada */
    public int getRentalId() { return rentalId; }

    /** @param rentalId ID de la renta */
    public void setRentalId(int rentalId) { this.rentalId = rentalId; }

    /** @return Monto pagado */
    public BigDecimal getAmount() { return amount; }

    /** @param amount Monto pagado */
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    /** @return Fecha del pago */
    public Timestamp getPaymentDate() { return paymentDate; }

    /** @param paymentDate Fecha del pago */
    public void setPaymentDate(Timestamp paymentDate) { this.paymentDate = paymentDate; }

    @Override
    public String toString() {
        return "Payment [ID=" + paymentId + ", Cliente=" + customerId + ", Empleado=" + staffId +
                ", Renta=" + rentalId + ", Monto=$" + amount + ", Fecha=" + paymentDate + "]";
    }
}
