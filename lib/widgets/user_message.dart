import 'package:cached_network_image/cached_network_image.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_gravatar/flutter_gravatar.dart';
import 'package:hakcgt/api_constants.dart';

/// User Message
class UserMessage extends StatelessWidget {
  const UserMessage({
    Key? key,
    required this.text,
  }) : super(key: key);

  final String text;

  @override
  Widget build(BuildContext context) {
    final gravatar = Gravatar(emailAddress);
    return Container(
      padding: const EdgeInsets.all(8),
      child: Row(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Expanded(
            child: Padding(
              padding: const EdgeInsets.all(8),
              child: Container(
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

                ),
              ),
            ),
          ),
          Expanded(
            flex: 5,
            child: Padding(
              padding: const EdgeInsets.only(
                left: 3,
                top: 10,
              ),
              child: SizedBox(
                height: 40,
                child: SelectionArea(
                  onSelectionChanged: (content) async {
                    if (content != null) {
                      await Clipboard.setData(
                        ClipboardData(text: content.plainText),
                      );
                    }
                  },
                  child: Text(
                    text,
                    style: TextStyle(
                      color: Color(0xFFE0E0E0), // Light text color
                      fontSize: 16,
                      fontWeight: FontWeight.w700,
                    ),
                  ),
                ),
              ),
            ),
          ),
        ],
      ),
    );
  }
}
