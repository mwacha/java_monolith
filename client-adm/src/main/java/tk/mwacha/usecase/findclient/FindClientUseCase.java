package tk.mwacha.usecase.findclient;

import lombok.RequiredArgsConstructor;
import tk.mwacha.gateway.ClientGateway;
import tk.mwacha.usecase.UseCaseInterface;

@RequiredArgsConstructor
public class FindClientUseCase implements UseCaseInterface<FindClientInput, FindClientOutput> {
    private final ClientGateway clientGateway;

    @Override
    public FindClientOutput execute(final FindClientInput input) {
        return FindClientOutput.from(clientGateway.find(input.id()));
    }
}
