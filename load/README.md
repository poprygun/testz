# Load Test

Demonstrates a simple load test that can be used to stress test REST API.

1. Adjust `io.microsamples.testz.util.Environment` to point to service base url.
2. Adjust `io.microsamples.testz.scenarios.GetRoots` for complete url.
3. From `load\` directory run
```bash
mvn gatling:test

```