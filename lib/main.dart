import 'package:flutter/material.dart';
import 'package:hakcgt/model/chatmodel.dart';
import 'package:hakcgt/widgets/user_input.dart';
import 'package:provider/provider.dart';
import 'package:http/http.dart';

void main() {
  WidgetsFlutterBinding.ensureInitialized();
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  @override
  Widget build(BuildContext context) {
    final chatcontroller = TextEditingController();

    return MaterialApp(
      title: 'Canto',
      home: IntroScreen(), // Set IntroScreen as the first screen
    );
  }
}

class IntroScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Color(0xFF292929), // Dark background color
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Image.asset(
              'images/cantologo.png', // Replace with the actual path to your logo image
              width: 240, // Adjust the width as needed
              height: 240, // Adjust the height as needed
            ),
            SizedBox(height: 20), // Add some space between the logo and text
            Text(
              'Welcome to Canto!',
              style: TextStyle(
                color: Colors.white,
                fontSize: 24,
                fontWeight: FontWeight.bold,
              ),
            ),
            ElevatedButton(
              onPressed: () {
                Navigator.pushReplacement(
                  context,
                  MaterialPageRoute(
                    builder: (context) => ChatScreen(),
                  ),
                );
              },
              child: Text('Get Started!'),
            ),
          ],
        ),
      ),
    );
  }
}

class ChatScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final chatcontroller = TextEditingController();

    return Scaffold(
      appBar: AppBar(
        backgroundColor: Color(0xFF292929), // Dark background color
        elevation: 0, // No elevation
        title: Text(
          '✨Canto - Redefining Wellness✨',
          style: TextStyle(
            color: Colors.white,
          ),
        ),
        centerTitle: true,
      ),
      body: MultiProvider(
        providers: [
          ChangeNotifierProvider(create: (_) => ChatModel()),
        ],
        child: Consumer<ChatModel>(builder: (context, model, child) {
          final messages = model.getMessages;
          return Stack(
            children: [
              // Chat container
              Container(
                margin: const EdgeInsets.only(bottom: 80),
                child: ListView(
                  children: [
                    const Divider(
                      color: Color(0xFFE0E0E0), // Light gray divider
                    ),
                    for (int i = 0; i < messages.length; i++) messages[i],
                  ],
                ),
              ),
              // User input
              UserInput(
                chatcontroller: chatcontroller,
              ),
            ],
          );
        }),
      ),
    );
  }
}
