package tk.mwacha.usecase.find;

import lombok.RequiredArgsConstructor;
import tk.mwacha.domain.Product;
import tk.mwacha.gateway.ProductGateway;
import tk.mwacha.usecase.DefaultUseCaseInterface;
import tk.mwacha.usecase.UseCaseInterface;

import java.util.List;

@RequiredArgsConstructor
public class FindProductUseCase implements UseCaseInterface<FindProductInputDTO, FindProductOutputDTO> {
    private final ProductGateway productGateway;

    @Override
    public FindProductOutputDTO execute(final FindProductInputDTO input) {
        return FindProductOutputDTO.from(productGateway.find(input.id()));
    }
}
