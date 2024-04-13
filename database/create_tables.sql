-- Creation of the 'variables' table
CREATE TABLE `variables`
(
    `id`           BIGINT       NOT NULL AUTO_INCREMENT,
    `name`         VARCHAR(255) NOT NULL,
    `value_type`   VARCHAR(255) NOT NULL,
    `is_composite` BOOLEAN      NOT NULL,
    `data_source`  VARCHAR(255),
    `template`     TEXT,
    PRIMARY KEY (`id`)
);

-- Creation of the 'conditions' table
CREATE TABLE `conditions`
(
    `id`          BIGINT NOT NULL AUTO_INCREMENT,
    `variable_id` BIGINT,
    `value`       TEXT,
    `operator`    VARCHAR(255),
    PRIMARY KEY (`id`),
    FOREIGN KEY (`variable_id`) REFERENCES `variables` (`id`)
);

-- Creation of the 'rules' table
CREATE TABLE `rules`
(
    `id`             BIGINT       NOT NULL AUTO_INCREMENT,
    `lender`         VARCHAR(255),
    `name`           VARCHAR(255) NOT NULL,
    `logic_operator` VARCHAR(255) NOT NULL,
    `is_primary`     BOOLEAN      NOT NULL,
    PRIMARY KEY (`id`)
);

-- Creation of the 'rule_segments' table
CREATE TABLE `rule_segments`
(
    `id`              BIGINT NOT NULL AUTO_INCREMENT,
    `rule_id`         BIGINT,
    `ra_condition_id` BIGINT,
    `f_condition_id`  BIGINT,
    `dv_condition_id` BIGINT,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`rule_id`) REFERENCES `rules` (`id`),
    FOREIGN KEY (`ra_condition_id`) REFERENCES `conditions` (`id`),
    FOREIGN KEY (`f_condition_id`) REFERENCES `conditions` (`id`),
    FOREIGN KEY (`dv_condition_id`) REFERENCES `conditions` (`id`)
);-- Creation of the 'variables' table
CREATE TABLE `variables`
(
    `id`           BIGINT       NOT NULL AUTO_INCREMENT,
    `name`         VARCHAR(255) NOT NULL,
    `value_type`   VARCHAR(255) NOT NULL,
    `is_composite` BOOLEAN      NOT NULL,
    `data_source`  VARCHAR(255),
    `template`     TEXT,
    PRIMARY KEY (`id`)
);

-- Creation of the 'conditions' table
CREATE TABLE `conditions`
(
    `id`          BIGINT NOT NULL AUTO_INCREMENT,
    `variable_id` BIGINT,
    `value`       TEXT,
    `operator`    VARCHAR(255),
    PRIMARY KEY (`id`),
    FOREIGN KEY (`variable_id`) REFERENCES `variables` (`id`)
);

-- Creation of the 'rules' table
CREATE TABLE `rules`
(
    `id`             BIGINT       NOT NULL AUTO_INCREMENT,
    `lender`         VARCHAR(255),
    `name`           VARCHAR(255) NOT NULL,
    `logic_operator` VARCHAR(255) NOT NULL,
    `is_primary`     BOOLEAN      NOT NULL,
    PRIMARY KEY (`id`)
);

-- Creation of the 'rule_segments' table
CREATE TABLE `rule_segments`
(
    `id`              BIGINT NOT NULL AUTO_INCREMENT,
    `rule_id`         BIGINT,
    `ra_condition_id` BIGINT,
    `f_condition_id`  BIGINT,
    `dv_condition_id` BIGINT,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`rule_id`) REFERENCES `rules` (`id`),
    FOREIGN KEY (`ra_condition_id`) REFERENCES `conditions` (`id`),
    FOREIGN KEY (`f_condition_id`) REFERENCES `conditions` (`id`),
    FOREIGN KEY (`dv_condition_id`) REFERENCES `conditions` (`id`)
);