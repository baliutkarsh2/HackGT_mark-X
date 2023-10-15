import 'package:flutter/material.dart';
import 'package:flutter_svg/flutter_svg.dart';

/// Loading widget
class Loading extends StatelessWidget {
  /// Constructor
  const Loading({
    super.key,
    required this.text,
  });
  /// Text
  final String text;

  @override
  Widget build(BuildContext context) {
    return Container(
      color: const Color(0xff444654),
      padding: const EdgeInsets.all(8),
      child: Row(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Expanded(
            flex: 1,
            child: Padding(
              padding: const EdgeInsets.all(8.0),
              child: Container(
                color: const Color(0xff444654),
                padding: const EdgeInsets.all(3),
                child: SvgPicture.asset(
                  'images/ai-avatar.svg',
                  height: 30,
                  width: 30,
                ),
              ),
            ),
          ),
          Expanded(
            flex: 5,
            child: Text(
              text,
              style: const TextStyle(
                color: Color(0xffffffff),
                fontSize: 16,
                fontWeight: FontWeight.w700,
              ),
            ),
          ),
        ],
      ),
    );
  }
}
