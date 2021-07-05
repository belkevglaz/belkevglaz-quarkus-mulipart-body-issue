#!/bin/bash

dd if=/dev/urandom of=huge128.bin iflag=fullblock bs=10M count=13
