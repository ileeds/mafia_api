ALTER DATABASE mafia_api CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;

CREATE TABLE `game` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `key` varchar(24) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `deleted_at` datetime,
  PRIMARY KEY (`id`),
  UNIQUE KEY `external_key` (`key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

CREATE TABLE `profile` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `key` varchar(24) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `deleted_at` datetime,
  PRIMARY KEY (`id`),
  UNIQUE KEY `external_key` (`key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
