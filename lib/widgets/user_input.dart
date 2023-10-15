import 'package:flutter/material.dart';
import 'package:flutter_gravatar/flutter_gravatar.dart';
import 'package:provider/provider.dart';

import '../api_constants.dart';
import '../model/chatmodel.dart';

class UserInput extends StatelessWidget {
  const UserInput({
    Key? key,
    required this.chatcontroller,
  }) : super(key: key);

  final TextEditingController chatcontroller;

  @override
  Widget build(BuildContext context) {
    final gravatar = Gravatar(emailAddress);

    return Align(
      alignment: Alignment.bottomCenter,
      child: Container(
        padding: const EdgeInsets.symmetric(horizontal: 16, vertical: 10),
        decoration: BoxDecoration(
          color: Color(0xFF292929), // Background color
          border: Border(
            top: BorderSide(
              color: Color(0xFF444654), // Border color
              width: 0.5,
            ),
          ),
        ),
        child: Row(
          children: [
            Container(
              width: 40,
              height: 40,
              decoration: BoxDecoration(
                shape: BoxShape.circle,
                color: Color(0xFFD8D8D8), // Light gray circle
              ),
              child: Image.asset(
                'images/fairy2.png', // Replace with your local image
                width: 40,
                height: 40,
                fit: BoxFit.cover,
              ),
            ),
            SizedBox(width: 16),
            Expanded(
              child: TextFormField(
                onFieldSubmitted: (e) {
                  context.read<ChatModel>().sendChat(e);
                  chatcontroller.clear();
                },
                controller: chatcontroller,
                style: TextStyle(
                  color: Color(0xFFE0E0E0), // Light text color
                ),
                decoration: InputDecoration(
                  hintText: 'How are you feeling today?',
                  hintStyle: TextStyle(color: Color(0xFFC0C0C0)), // Gray hint text
                  filled: true,
                  fillColor: Color(0xFF1A1A1A), // Darker text field
                  suffixIcon: Icon(
                    Icons.send,
                    color: Color(0xFFACACBE), // Icon color
                  ),
                  focusedBorder: OutlineInputBorder(
                    borderSide: BorderSide.none,
                    borderRadius: BorderRadius.circular(5),
                  ),
                  border: OutlineInputBorder(
                    borderRadius: BorderRadius.circular(5),
                  ),
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
