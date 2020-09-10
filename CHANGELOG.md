# Changelog

## [Unreleased]
### Changed
- `CoroutineDispatcher` replaced with `CoroutineContext` in runtime builder.
- `Dispatch` deprecated in favor of `Job`.
- `oolong.Oolong.runtime` deprecated in favor of `oolong.runtime`.
- `disposableEffect` deprecated.
- Allow incoming types to be nullable.
- Deprecate `Next`, `Init`, `Update`, `View`, and `Render` in preference of underlying types.

## [2.0.7] - 2020-08-17
### Added
- Update Kotlin to 1.4.0
- Update Kotlin Coroutines to 1.3.9

## [2.0.6] - 2020-06-30
### Fixed
- Maven Central artifacts.

## [2.0.5] - 2020-06-10
### Added
- Update Kotlin Coroutines to 1.3.7

## [2.0.4] - 2020-05-17
### Added
- Update Kotlin Coroutines to 1.3.6
- Add samples link to readme

### Fixed
- Allow dispatcher specification.

## [2.0.3] - 2020-04-25
### Added
- Update Kotlin to 1.3.72
- Update Kotlin Coroutines to 1.3.5

## Removed
- Deprecated coroutine scope and context arguments in runtime creator function.
- Remove deprecated runtime creator function.

## [2.0.2] - 2020-01-08
### Added
- Update Kotlin to 1.3.61
- Update Kotlin Coroutines to 1.3.3

### Removed
- Samples moved to https://github.com/oolong-kt/oolong-samples

## [2.0.1] - 2019-06-20
### Added
- Update Kotlin to 1.3.40

### Changed
- Remove default arguments for Runtime constructor

## [2.0.0] - 2019-05-31
### Added
- Add samples

### Changed
- Move to oolong-kt org and update packages
- Change core types from classes to functions

## [1.0.0] - 2018-08-01

Initial release

[Unreleased]: https://github.com/oolong-kt/oolong/compare/v2.0.7...HEAD
[2.0.7]: https://github.com/oolong-kt/oolong/compare/v2.0.6...v2.0.7
[2.0.6]: https://github.com/oolong-kt/oolong/compare/v2.0.5...v2.0.6
[2.0.5]: https://github.com/oolong-kt/oolong/compare/v2.0.4...v2.0.5
[2.0.4]: https://github.com/oolong-kt/oolong/compare/v2.0.3...v2.0.4
[2.0.3]: https://github.com/oolong-kt/oolong/compare/v2.0.2...v2.0.3
[2.0.2]: https://github.com/oolong-kt/oolong/compare/v2.0.1...v2.0.2
[2.0.1]: https://github.com/oolong-kt/oolong/compare/v2.0.0...v2.0.1
[2.0.0]: https://github.com/oolong-kt/oolong/compare/v1.0.0...v2.0.0
[1.0.0]: https://github.com/oolong-kt/oolong/releases/tag/v1.0.0
