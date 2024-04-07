package view;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ValidatorTest {

    @ParameterizedTest
    @MethodSource("provideNamesAndExpected")
    void validateName(String names, boolean expected) {
        // when
        boolean result = Validator.validateName(names);
        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideNamesAndExpected() {
        return Stream.of(
            Arguments.of("a,b,c", true),
            Arguments.of("a,bbb, ", false),
            Arguments.of("ab,asdf, as", false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideBetAmountAndExpected")
    void validateBetAmountFalse(String betAmount, boolean expected) {
        // when
        boolean result = Validator.validateBetAmount(betAmount);
        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideBetAmountAndExpected() {
        return Stream.of(
            Arguments.of("0", false),
            Arguments.of("1000", true),
            Arguments.of("11", true),
            Arguments.of("-1", false),
            Arguments.of(" ", false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideYesOrNoAndExpected")
    void validateYesOrNo(String yesOrNo, boolean expected) {
        // when
        boolean result = Validator.validateYesOrNo(yesOrNo);
        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideYesOrNoAndExpected() {
        return Stream.of(
            Arguments.of("y", true),
            Arguments.of("Y", false),
            Arguments.of("N", false),
            Arguments.of("n", true)
        );
    }
}