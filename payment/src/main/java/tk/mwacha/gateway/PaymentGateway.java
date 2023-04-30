package tk.mwacha.gateway;

import tk.mwacha.domain.Transaction;

public interface PaymentGateway {
    Transaction save(Transaction input);
}
