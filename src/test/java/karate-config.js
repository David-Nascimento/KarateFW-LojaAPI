function fn(){
    var env = karate.env;
    var config = { env: env }
    var headers = {"cache-control": "no-cache"}
    karate.configure('ssl', true)
    if (!env) { env = 'dev'; }

    switch(env) {
        case 'dev':
            config = karate.read('classpath:lojaVirtual/services/support/config/domain.yaml')['uat']
        break;
        case 'qa':
            config = karate.read('classpath:lojaVirtual/services/support/config/domain.yaml')['qa']
        break;
    }

    karate.log('karate.env system property was:', env);
    karate.configure('headers', headers);
    karate.configure('retry', { count: 10, interval: 5000})
    config.faker = Java.type('com.github.javafaker.Faker');
    return config;
}