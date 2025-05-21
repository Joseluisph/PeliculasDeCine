package com.sakila.bll;

import com.sakila.interfaces.iDatapost;
import com.sakila.models.Payment;

import java.util.ArrayList;
import java.util.List;

public class PaymentManager implements iDatapost<Payment> {

    private final List<Payment> pagos = new ArrayList<>();

    @Override
    public boolean post(Payment pago) {
        return pagos.add(pago);
    }

    @Override
    public Payment get(int id) {
        for (Payment p : pagos) {
            if (p.getPaymentId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Payment> get() {
        return pagos;
    }

    @Override
    public boolean put(Payment pago) {
        for (int i = 0; i < pagos.size(); i++) {
            if (pagos.get(i).getPaymentId() == pago.getPaymentId()) {
                pagos.set(i, pago);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        return pagos.removeIf(p -> p.getPaymentId() == id);
    }
}
