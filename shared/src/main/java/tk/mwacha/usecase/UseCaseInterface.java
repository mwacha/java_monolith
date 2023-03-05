package tk.mwacha.usecase;

public interface UseCaseInterface <I, O>{

    O execute(I input);
}
