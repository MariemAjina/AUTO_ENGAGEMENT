#!/bin/bash

FULL_PATH_TO_GOOGLE_PLISTS=${PROJECT_DIR}/Prebuild/ConfigurationFiles/
PATH_TO_GOOGLE_PLISTS="Firebase/${TARGET_NAME}/GoogleService-Info-${CONFIGURATION}.plist"
cp -r "$FULL_PATH_TO_GOOGLE_PLISTS/$PATH_TO_GOOGLE_PLISTS" "${BUILT_PRODUCTS_DIR}/${PRODUCT_NAME}.app/GoogleService-Info.plist"

