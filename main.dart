import 'package:flutter/material.dart';

void main() {
  runApp(
    MyApp(),
  );
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        backgroundColor: Colors.teal,
        body: SafeArea(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              CircleAvatar(
                radius: 65.0,
                backgroundImage: AssetImage('images/dan.JPG'),
              ),
              SizedBox(
                height: 15,
              ),
              Text(
                'Dan McCarthy',
                style: TextStyle(
                  fontSize: 40.0,
                  color: Colors.white,
                  fontWeight: FontWeight.bold,
                  fontFamily: 'Pacifico',
                ),
              ),
              Text(
                'Computer Science Undergrad',
                style: TextStyle(
                    fontSize: 25.0,
                    color: Colors.white30,
                    fontWeight: FontWeight.bold,
                    fontFamily: 'Source Sans Pro'),
              ),
              SizedBox(
                height: 20.0,
                width: 150,
                child: Divider(
                  color: Colors.white30,
                ),
              ),
              Card(
                margin: EdgeInsets.symmetric(vertical: 10.0, horizontal: 25.0),
                color: Colors.white,
                child: Padding(
                  padding: const EdgeInsets.all(10.0),
                  child: ListTile(
                      leading: Icon(
                        Icons.phone,
                      ),
                      title: Text(
                        '(978)-501-6292',
                        style: TextStyle(
                          fontSize: 25.0,
                          color: Colors.teal.shade900,
                          fontFamily: 'Source Sans Pro',
                        ),
                      )),
                ),
              ),
              SizedBox(
                height: 15,
              ),
              Card(
                margin: EdgeInsets.symmetric(vertical: 10.0, horizontal: 25.0),
                color: Colors.white,
                child: Padding(
                  padding: EdgeInsets.all(25.0),
                  child: Row(
                    children: <Widget>[
                      Icon(
                        Icons.mail,
                      ),
                      SizedBox(
                        width: 10.0,
                      ),
                      Text(
                        'djmccarthy32@gmail.com',
                        style: TextStyle(
                          fontSize: 20.0,
                          color: Colors.teal,
                          fontFamily: 'Source Sans Pro',
                        ),
                      ),
                    ],
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}

/*Row(
children: <Widget>[
Icon(
Icons.phone,
),
SizedBox(
width: 10.0,
),
Text(
'(978)- 501- 6292',
style: TextStyle(
fontSize: 20.0,
color: Colors.teal,
fontFamily: 'Source Sans Pro',
),
),
],
),
*/
