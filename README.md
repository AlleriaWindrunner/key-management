# key-management

> Implementation of the java version of the shamir key sharing algorithm.


## Add to your project

```java
<dependency>
  <groupId>io.github.alleriawindrunner</groupId>
  <artifactId>key-management</artifactId>
  <version>1.0.0</version>
</dependency>
```

## Use the thing

```java
/**
 * 密钥分片测试
 * @author eleven
 * @date 2023年02月17日 10:43 PM
 * @see
 * @since
 */

public class ShardingTest {

    @Test
    public void testSplitAndRecovered() throws Exception {
        //生成一个私钥
        byte[] privateKey = new byte[]{-12, 15, 47, -3, -81, -103, 47, 64, -47, -72, -108, -12, 49, 37, -119, -106, -98, 57, 89, -99, 90, -29, 92, -39, -67, 82, -12, -23, -98, 82, 56, -77};
        String privateKeyBeforeSharding = KeyPresenter.asString(privateKey);
        //开始分片，分解为5片，凑齐任意3片才能还原
        PkeyShardingService shardingService
                = new PkeyShardingService();
        List<String> shards = shardingService.shardingPKey(privateKey, 3, 2);
        //还原
        List<String> recoveredShards = new ArrayList<>();
        recoveredShards.add(shards.get(0));
        recoveredShards.add(shards.get(2));
        byte[] recovered = shardingService.recoverPKey(recoveredShards);
        String privateKeyAfterRecovered = KeyPresenter.asString(recovered);
        Assert.assertTrue(privateKeyBeforeSharding.equals(privateKeyAfterRecovered));
    }
}
```
