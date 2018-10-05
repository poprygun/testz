[{
    'name': 'consume',
    'type': 'simple',
    'exchange-type': 'fanout',
    'producer-rate-limit': 10.0,
    'params': [{
        'time-limit': 10,
        'producer-count': 2,
        'consumer-count': 15
    }]
},
    {
        'name': 'produce',
        'type': 'simple',
        'exchange-type': 'fanout',
        'producer-rate-limit': 10.0,
        'params': [{
            'time-limit': 10,
            'producer-count': 15,
            'consumer-count': 2
        }]
    }
]