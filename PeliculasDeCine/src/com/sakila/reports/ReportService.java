import com.sakila.models.Payment;
import com.sakila.repository.PaymentRepository;
import java.util.List;

/**
 * Servicio para generación de reportes con pagos.
 */
public class ReportService {

    /**
     * Muestra todos los pagos en consola.
     */
    public void imprimirPagos() {
        PaymentRepository repo = new PaymentRepository();
        List<Payment> pagos = repo.get();  // ✅ corregido

        pagos.forEach(System.out::println);
    }

    /**
     * Calcula y muestra el total de pagos realizados.
     */
    public void totalPagos() {
        PaymentRepository repo = new PaymentRepository();
        List<Payment> pagos = repo.get();  // ✅ corregido

        double total = pagos.stream()
                .mapToDouble(p -> p.getAmount().doubleValue())
                .sum();

        System.out.println("💰 Total recaudado: $" + total);
    }

    /**
     * Cuenta la cantidad total de pagos.
     */
    public void contarPagos() {
        PaymentRepository repo = new PaymentRepository();
        System.out.println("📊 Total de pagos: " + repo.get().size());  // ✅ corregido
    }
}
