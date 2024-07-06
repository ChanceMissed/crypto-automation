CREATE TABLE `report_histories`
(
    `market`      varchar(100) NOT NULL,
    `price`       varchar(100) NOT NULL,
    `reported_at` datetime     NOT NULL,
    `id`          int          NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (`id`)
)