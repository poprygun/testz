## HOVERFLY 

### Demonstrates

- Capture controller calls using Hoverfly `HoverflyRule.inCaptureMode` mode
- Mock controller responses using Hoverfly `HoverflyRule.inSimulationMode` mode

### Example running Hoverfly Proxy

```bash
./hoverctl start
./hoverctl mode capture
curl --proxy http://localhost:8500 'http://localhost:8080/quadratic?a=2&b=6&c=4';
./hoverctl export simulation.json
./hoverctl stop
```