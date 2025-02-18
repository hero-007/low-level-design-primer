package questions.multiLevelCache.providers;

import multiLevelCache.models.ReadResponse;
import multiLevelCache.models.UsageResponse;
import multiLevelCache.models.WriteResponse;

public interface ICacheLevel <Key, Value>{
    ReadResponse<Value> get(Key key);
    WriteResponse set(Key key, Value value);

    UsageResponse getUsage();
}
