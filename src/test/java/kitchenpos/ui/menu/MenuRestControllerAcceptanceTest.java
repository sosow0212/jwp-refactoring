package kitchenpos.ui.menu;

import kitchenpos.domain.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static kitchenpos.fixture.MenuFixture.메뉴_생성;
import static kitchenpos.fixture.MenuFixture.메뉴_생성_요청;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class MenuRestControllerAcceptanceTest extends MenuRestControllerAcceptanceTestFixture {

    private Menu 메뉴;

    @BeforeEach
    void setup() {
        메뉴 = 메뉴_생성("상품", BigDecimal.valueOf(10000), menuGroup.getId(), List.of(menuProduct));
    }

    @Test
    void 메뉴를_생성한다() {
        // when
        var 생성_결과 = 메뉴를_생성한다("/api/menus", 메뉴_생성_요청(메뉴));

        // then
        메뉴가_성공적으로_생성된다(생성_결과, 메뉴);
    }

    @Test
    void 메뉴들을_조회한다() {
        // given
        var 생성된_메뉴들 = 메뉴_데이터를_생성한다();

        // when
        var 조회_결과 = 메뉴를_전체_조회한다("/api/menus");

        // then
        메뉴들이_성공적으로_생성된다(조회_결과, 생성된_메뉴들);
    }
}
