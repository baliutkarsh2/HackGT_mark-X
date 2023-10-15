/*import 'package:http/http.dart' as http;
import 'dart:convert';

Future<String> sendMessageToOpenAI(String message) async {
  const apiKey = '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'; // Replace with your OpenAI API key
  const endpoint = 'https://api.openai.com/v1/engines/davinci-codex/completions';

  try {
    final response = await http.post(
      Uri.parse(endpoint),
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer $apiKey',
      },
      body: jsonEncode({
        'prompt': message,
        'max_tokens': 1000, // Adjust as needed
      }),
    );

    if (response.statusCode == 200) {
      return jsonDecode(response.body)['choices'][0]['text'];
    } else {
      throw Exception('Failed to connect to OpenAI API');
    }
  } catch (e) {
    throw Exception('Failed to connect to OpenAI API: $e');
  }
}
*/
import 'dart:convert';
import 'dart:io';
import 'package:http/http.dart' as http;

Future<void> main(List<String> arg) async {
  stdout.writeln('What do you like to ask?');
  final prompt = stdin.readLineSync();
  if (prompt != null) print(await callChatGPT(prompt));
}

Future<String?> callChatGPT(String prompt) async {
  const apiKey = "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";
  const apiUrl = "https://api.openai.com/v1/completions";

  final headers = {
    'Content-Type': 'application/json',
    'Authorization': 'Bearer $apiKey'
  };

  final body = jsonEncode(
    {
      "model": "text-davinci-003",
      'prompt': prompt,
      'max_tokens': 7, // Adjust as needed
    },
  );
  try {
    final response = await http.post(
      Uri.parse(apiUrl),
      headers: headers,
      body: body,
    );
    if (response.statusCode == 200) {
      final jsonResponse = jsonDecode(response.body);
      final result = jsonResponse['choices'][0]['text'];
      return result;
    } else {
      print(
        'Failed to call ChatGPT API: ${response.statusCode} ${response.body}',
      );
      return null;
    }
  } catch (e) {
    print("Error calling ChatGPT API: $e");
    return null;
  }
}