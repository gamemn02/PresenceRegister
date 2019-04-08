package dz.deepwork.gamemn02.presenceregister.data.members;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;

import dz.deepwork.gamemn02.presenceregister.data.NetworkService;
import dz.deepwork.gamemn02.presenceregister.data.TestData;

public class TestNetworkService extends NetworkService {

    public TestNetworkService(Executor networkExecutor) {
        super(networkExecutor);
    }
}
