package com.example.chatgpt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Choices {

    ChatGptMessage message;

    String finish_reason;

    Integer index;
}