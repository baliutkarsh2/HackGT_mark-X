import 'package:animated_text_kit/animated_text_kit.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_svg/flutter_svg.dart';

/// Rendering state
enum RenderingState {
  /// Not rendered
  none,
  /// Rendering complete
  complete
}

/// AI Message class
class AiMessage extends StatefulWidget {
  const AiMessage({
    Key? key,
    required this.text,
  }) : super(key: key);

  final String text;

  @override
  State<AiMessage> createState() => _AiMessageState();
}

class _AiMessageState extends State<AiMessage> {
  RenderingState renderingState = RenderingState.none;
  Size renderSize = Size.zero;
  GlobalKey textKey = GlobalKey();
  bool _hasRendered = false;

  @override
  Widget build(BuildContext context) {
    return Container(
      color: Color(0xFF292929), // Dark background color, matching UserInput
      padding: const EdgeInsets.all(8),
      child: Row(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Expanded(
            child: Padding(
              padding: const EdgeInsets.all(10),
              child: Container(
                child: Image.asset(
                  'images/fairy.png',
                  width: 40,
                  height: 90,
                ),
              ),
            ),
          ),

          Expanded(
            flex: 5,
            child: renderingState != RenderingState.complete && !_hasRendered
                ? AnimatedTextKit(
              key: textKey,
              animatedTexts: [
                TypewriterAnimatedText(
                  widget.text,
                  textStyle: TextStyle(
                    color: Color(0xFFE0E0E0), // Light text color
                    fontSize: 16,
                    fontWeight: FontWeight.w700,
                  ),
                ),
              ],
              onFinished: () {
                setState(() {
                  _hasRendered = true;
                  renderingState = RenderingState.complete;
                  renderSize = (textKey.currentContext != null
                      ? textKey.currentContext!.size
                      : Size(300, 100))!;
                });
              },
              totalRepeatCount: 1,
            )
                : SizedBox(
              width: renderSize.width,
              height: renderSize.height,
              child: SelectableText.rich(
                TextSpan(
                  text: widget.text,
                  style: TextStyle(
                    color: Color(0xFFE0E0E0), // Light text color
                    fontSize: 16,
                    fontWeight: FontWeight.w700,
                  ),
                ),
                onSelectionChanged: (selection, cause) async {
                  if (cause != null &&
                      cause == SelectionChangedCause.longPress) {
                    final selected =
                    widget.text.substring(selection.start, selection.end);
                    await Clipboard.setData(
                        ClipboardData(text: selected));
                  }
                },
              ),
            ),
          ),
        ],
      ),
    );
  }
}
