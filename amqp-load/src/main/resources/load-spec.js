[{
    'name': 'consume',
    'type': 'simple',
    'uri': 'amqp://593502c1-735d-4ebd-b880-fe46846ebfe0:7ifeoij0kea3ck6239ddclkj2c@rabbitmq.local.pcfdev.io/d2cd1f31-3855-4301-a88c-ad02b3e92817',
    'exchange-type': 'fanout',
    'producer-rate-limit': 10.0,
    'params': [{
        'time-limit': 10,
        'producer-count': 3,
        'consumer-count': 15
    }]
},
    {
        'name': 'produce',
        'type': 'simple',
        'uri': 'amqp://593502c1-735d-4ebd-b880-fe46846ebfe0:7ifeoij0kea3ck6239ddclkj2c@rabbitmq.local.pcfdev.io/d2cd1f31-3855-4301-a88c-ad02b3e92817',
        'exchange-type': 'fanout',
        'producer-rate-limit': 10.0,
        'params': [{
            'time-limit': 10,
            'producer-count': 15,
            'consumer-count': 3
        }]
    }
]