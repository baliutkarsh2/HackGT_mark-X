/*
import 'dart:html';


import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:introduction_screen/introduction_screen.dart';

final List<PageViewModel> pages = [
  PageViewModel(
    title: "Welcome to Canto",
    body: "Explore a new way to redefine wellness with Canto.",
    image: Image.asset('assets/intro/intro_image_1.png'),
    decoration: const PageDecoration(
      pageColor: Colors.blue,
    ),
  ),
  PageViewModel(
    title: "Discover Music Therapy",
    body: "Experience the healing power of music therapy in your journey.",
    image: Image.asset('assets/intro/intro_image_2.png'),
    decoration: const PageDecoration(
      pageColor: Colors.green,
    ),
  ),
  PageViewModel(
    title: "Get Started",
    body: "Start your wellness journey with Canto now.",
    image: Image.asset('assets/intro/intro_image_3.png'),
    decoration: const PageDecoration(
      pageColor: Colors.orange,
    ),
  ),
];

void main() {
  WidgetsFlutterBinding.ensureInitialized();
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Canto',
      home: IntroductionScreen(
        pages: pages,
        done: const Text("Get Started"),
        onDone: () {
          // Handle the "Get Started" button click, e.g., navigate to the main app.
          runApp(YourMainApp()); // Replace with your main app
        },
      ),
    );
  }
}
 */