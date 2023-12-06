package home.ags.validation;

import java.util.List;

public record ValidationErrorResponse(List<Violation> violations) {
}
