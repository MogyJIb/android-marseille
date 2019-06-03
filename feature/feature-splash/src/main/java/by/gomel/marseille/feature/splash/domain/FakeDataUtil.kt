package by.gomel.marseille.feature.splash.domain

import by.gomel.marseille.data.models.*


fun fakeServices() = listOf(
        Service(category = ServiceCategory.HAIR,
                name = "Мужская стрижка",
                minPrice = 13.0,
                maxPrice = 20.0),
        Service(category = ServiceCategory.HAIR,
                name = "Женская стрижка",
                minPrice = 17.0,
                maxPrice = 21.0),
        Service(category = ServiceCategory.HAIR,
                name = "Полировка волос",
                minPrice = 29.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.HAIR,
                name = "Окрашивание волос",
                minPrice = 15.0,
                maxPrice = 38.0),
        Service(category = ServiceCategory.HAIR,
                name = "Сложное окрашивание",
                minPrice = 100.0,
                maxPrice = 250.0),
        Service(category = ServiceCategory.HAIR,
                name = "Ботокс",
                minPrice = 41.50,
                maxPrice = 80.0),
        Service(category = ServiceCategory.HAIR,
                name = "Brazilian blowout",
                minPrice = 110.0,
                maxPrice = 170.0),
        Service(category = ServiceCategory.HAIR,
                name = "Лечение волос",
                minPrice = 45.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.HAIR,
                name = "Прическа",
                minPrice = 48.0,
                maxPrice = 60.0),

        Service(category = ServiceCategory.MANICURE,
                name = "Маникюр",
                minPrice = 12.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.MANICURE,
                name = "Маникюр + лак",
                minPrice = 16.50,
                maxPrice = -1.0),
        Service(category = ServiceCategory.MANICURE,
                name = "Маникюр + гельлак",
                minPrice = 28.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.MANICURE,
                name = "Маникюр + гельлак + френч",
                minPrice = 33.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.MANICURE,
                name = "Снятие гельлака",
                minPrice = 5.0,
                maxPrice = -1.0),

        Service(category = ServiceCategory.PEDICURE,
                name = "Педикюр",
                minPrice = 25.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.PEDICURE,
                name = "Педикюр + лак",
                minPrice = 29.50,
                maxPrice = -1.0),
        Service(category = ServiceCategory.PEDICURE,
                name = "Педикюр + 1фаза гель",
                minPrice = 33.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.PEDICURE,
                name = "Педикюр + гельлак",
                minPrice = 38.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.PEDICURE,
                name = "Педикюр + гельлак + френч",
                minPrice = 42.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.PEDICURE,
                name = "Снятие гельлака",
                minPrice = 5.0,
                maxPrice = -1.0),

        Service(category = ServiceCategory.MAKE_UP,
                name = "Консультация",
                minPrice = 20.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.MAKE_UP,
                name = "Дневной",
                minPrice = 60.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.MAKE_UP,
                name = "Вечерний",
                minPrice = 60.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.MAKE_UP,
                name = "Свадебный",
                minPrice = 80.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.MAKE_UP,
                name = "Мужской",
                minPrice = 45.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.MAKE_UP,
                name = "Выезд визажиста",
                minPrice = 10.0,
                maxPrice = -1.0),

        Service(category = ServiceCategory.MAGIC_WHITE,
                name = "EXPRESS отбеливание зубов",
                minPrice = 55.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.MAGIC_WHITE,
                name = "COMPLEX отбеливание зубов",
                minPrice = 83.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.MAGIC_WHITE,
                name = "SUPER отбеливание зубов",
                minPrice = 105.0,
                maxPrice = -1.0),

        Service(category = ServiceCategory.TOOL_SHARPENING,
                name = "Маникюрные щипчики",
                minPrice = 7.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.TOOL_SHARPENING,
                name = "Маникюрные ножницы",
                minPrice = 6.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.TOOL_SHARPENING,
                name = "Пушер (шабер)",
                minPrice = 4.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.TOOL_SHARPENING,
                name = "Прямые ножницы",
                minPrice = 7.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.TOOL_SHARPENING,
                name = "Филировочные ножницы",
                minPrice = 7.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.TOOL_SHARPENING,
                name = "Горячие ножницы",
                minPrice = 10.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.TOOL_SHARPENING,
                name = "Ножи для машинки",
                minPrice = 12.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.TOOL_SHARPENING,
                name = "Ножи для мясорубки",
                minPrice = 12.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.TOOL_SHARPENING,
                name = "Опасная бритва (скальпель)",
                minPrice = 6.0,
                maxPrice = -1.0),
        Service(category = ServiceCategory.TOOL_SHARPENING,
                name = "Бытовой нож (1 см лезвия)",
                minPrice = 0.30,
                maxPrice = -1.0)
)


fun fakeGoods() = listOf(
        Goods(category = GoodsCategory.ITALY,
                name = "Energizing blend conditioner",
                imageUrl = "https://static.tildacdn.com/tild6439-3532-4463-b133-353861396433/img_2018-09-03_17-36.jpg",
                description = "Кондиционер для тонких, истончающих и хрупких волос, он распутывает и придает мягкость," +
                        " не взвешивая волосы. Выбранная смесь ботанических экстрактов и мощные кондиционеры для волос " +
                        "активируют вал для волос и обеспечивают мягкое, приятное, возбуждающее ощущение.\n" +
                        "Активные ингредиенты: пантенол, витамин Е.\n" +
                        "\n" +
                        "ДОСТУПНЫЕ ФОРМАТЫ: 300 мл\n" +
                        "\n" +
                        "Применение: наносить на влажные, чистые волосы, мягко массировать и оставлять на несколько" +
                        " минут при легком нажатии, используя кончики пальцев круговыми движениями, чтобы улучшить" +
                        " микроциркуляцию кожи головы. Расчешите и тщательно промойте.",
                price = 32.0),
        Goods(category = GoodsCategory.ITALY,
                name = "Smoothing cream",
                imageUrl = "https://static.tildacdn.com/tild3030-6261-4265-b263-373139353838/img_2017-06-14_11-01.jpg",
                description = "Защищает волосы во время сушки и обеспечивает естественную поддержку. Выравнивает " +
                        "кутикулу, дольше сохраняет гладкость и нейтрализует пушистость. Оставляет волосы мягкими" +
                        " и блестящими, не утяжеляя их. \n" +
                        "Результат: гладкие и мягкие волосы. Супер глянцевый эффект.\n" +
                        "Активные ингредиенты: UV фильтр, протеины киноа, протеины шелка\n" +
                        "\n" +
                        "ДОСТУПНЫЕ ФОРМАТЫ: 175 мл \n" +
                        "\n" +
                        "Применение: Необходимое количество средства нанести на чистые влажные волосы. Приступить к укладке.",
                price = 31.0)
)


fun fakeEmployees() = listOf(
        Employee(
                ServiceCategory.HAIR,
                "Юля Башилова",
                "Парикмахер",
                "https://static.tildacdn.com/tild3439-3738-4664-b962-313965393065/IMG_3483.JPG"
        ),
        Employee(
                ServiceCategory.HAIR,
                "Ирина Якименко",
                "Парикмахер",
                "https://static.tildacdn.com/tild3965-3562-4531-a235-626432303533/IMG_3876.JPG"
        ),
        Employee(
                ServiceCategory.MANICURE,
                "Олеся Булах",
                "Мастер ногтевого сервиса",
                "https://static.tildacdn.com/tild6565-6264-4238-b133-323465656134/IMG_3301.JPG"
        )
)