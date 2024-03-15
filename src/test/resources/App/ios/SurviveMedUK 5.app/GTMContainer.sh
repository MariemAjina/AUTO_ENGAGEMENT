#!/bin/bash

GTM_FOLDER=
rm -vf "${PROJECT_DIR}"/container/*

echo ${CONFIGURATION}

if [ "${CONFIGURATION}" == "PROD" ]; then
    GTM_FOLDER="Firebase/${TARGET_NAME}/${CONFIGURATION}"
else
    GTM_FOLDER="Firebase/${TARGET_NAME}/DEV"
fi

GTM_FILE_PATH="${PROJECT_DIR}/ConfigurationFiles/$GTM_FOLDER"
GTM_FILE_FULL_PATH=$(find $GTM_FILE_PATH -name "*GTM*")
echo $GTM_FILE_FULL_PATH
cp  $GTM_FILE_FULL_PATH "${PROJECT_DIR}/Prebuild/container/"

