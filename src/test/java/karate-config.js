function fn(){
    var env = karate.env;
    var config = { karate.env }
    var headers = {"cache-control": "no-cache"}
    karate.configure('ssl', true)

    switch(env) {
        case 'dev':
            config = karate.read('classpath:support/config/domain.yaml');
            break;
        case 'qa':
            config = karate.read('classpath:support/config/domain.yaml');
            break;
        default:
            System.out.printl("...")
        break;
    }

    karate.configure('headers', headers);
    karate.configure('retry', { count: 10, interval: 5000});
    return config;
}