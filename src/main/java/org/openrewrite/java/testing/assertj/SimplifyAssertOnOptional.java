/*
 * Copyright 2024 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * https://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.openrewrite.java.testing.assertj;

import com.google.errorprone.refaster.annotation.AfterTemplate;
import com.google.errorprone.refaster.annotation.BeforeTemplate;
import org.openrewrite.java.template.RecipeDescriptor;
import static org.assertj.core.api.Assertions.*;

import java.util.Optional;

@RecipeDescriptor(
        name = "Simplify assertions on optionals",
        description = "Simplifies various assertions on optionals to improve code readability."
)
public class SimplifyAssertOnOptional {

    @RecipeDescriptor(
            name = "Simplify `assertThat(o.isEmpty()).isFalse()`",
            description = "Simplify `assertThat(o.isEmpty()).isFalse()` to `assertThat(o).isNotEmpty()`."
    )
    public class SimplifyToIsNotEmpty {

        @BeforeTemplate
        void before(Optional<?> o) {
            assertThat(o.isEmpty()).isFalse();
        }

        @AfterTemplate
        void after(Optional<?> o) {
            assertThat(o).isPresent();
        }
    }

    @RecipeDescriptor(
            name = "Simplify `assertThat(o.isEmpty()).isTrue()`",
            description = "Simplify `assertThat(o.isEmpty()).isTrue()` to `assertThat(o).isEmpty()`."
    )
    public class SimplifyToIsEmpty {

        @BeforeTemplate
        void before(Optional<?> o) {
            assertThat(o.isEmpty()).isTrue();
        }

        @AfterTemplate
        void after(Optional<?> o) {
            assertThat(o).isEmpty();
        }
    }

    @RecipeDescriptor(
            name = "Simplify `assertThat(o.isPresent()).isFalse()`",
            description = "Simplify `assertThat(o.isPresent()).isFalse()` to `assertThat(o).isNotPresent()`."
    )
    public class SimplifyToIsNotPresent {

        @BeforeTemplate
        void before(Optional<?> o) {
            assertThat(o.isPresent()).isFalse();
        }

        @AfterTemplate
        void after(Optional<?> o) {
            assertThat(o).isNotPresent();
        }
    }

    @RecipeDescriptor(
            name = "Simplify `assertThat(o.isPresent()).isTrue()`",
            description = "Simplify `assertThat(o.isPresent()).isTrue()` to `assertThat(o).isPresent()`."
    )
    public class SimplifyToIsPresent {

        @BeforeTemplate
        void before(Optional<?> o) {
            assertThat(o.isPresent()).isTrue();
        }

        @AfterTemplate
        void after(Optional<?> o) {
            assertThat(o).isPresent();
        }
    }

}