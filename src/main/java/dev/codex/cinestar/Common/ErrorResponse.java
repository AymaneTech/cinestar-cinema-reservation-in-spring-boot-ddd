package dev.codex.cinestar.Common;

import java.util.Map;

public record ErrorResponse(int status, String message, Map<String, String> errors) {}