var net = require('net');
var eol = require('os').EOL;

var srvr = net.createServer();
var clientList = [];

srvr.on('connection', function (client) {
    client.name = client.remoteAddress + ':' + client.remotePort;
    client.write('Welcome, ' + client.name + eol);
    clientList.push(client);

    client.on('data', function (data) {
        broadcast(data, client);
    });
});

function broadcast(data, client) {
    data = data.toString().substring(0, data.length - 2);
    if (data == "\\list") {
        list(client);
    }
    else if (data.substring(0, 7) == "\\rename") {
        var newName = data.substring(8, data.length);
        rename(newName, client);
    }
    else if (data.substring(0, 8) == "\\private") {
        var split_data = data.split(" ");
        var receiver = split_data[1];
        for (var i in clientList) {
            if (clientList[i].name == receiver) {
                var msg = split_data.slice(2).join(" ");
                privateMessage(msg, client, clientList[i]);
            }


        }
    }
    else {
        for (var i in clientList) {
            if (client !== clientList[i]) {
                clientList[i].write(client.name + " says " + data + "\n");
            }
        }
    }
}

    function list(client) {
        client.write("Other Users:\n");
        for (var i in clientList) {
            if (client !== clientList[i]) {
                client.write(clientList[i].name + "\n");
            }
        }
    }

    function rename(newName, client) {
        client.name = newName;
        client.write("Your new name is " + newName + "\n");
    }

    function privateMessage(data, client, receiver) {

        receiver.write(data + " from " + client.name + "\n");


    }


srvr.listen(9000);


