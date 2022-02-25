# syntax=docker/dockerfile:1
FROM node:12-alpine
RUN apk add --no-cache python2 g++ make
WORKDIR /Capita
COPY . .
RUN yarn install --production
CMD ["echo", "Hello World!"]
