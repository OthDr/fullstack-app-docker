# Use official Node.js 22.16.0 image
FROM node:22.16.0-alpine

# Set working directory
WORKDIR /app

# Install dependencies
COPY package*.json ./
RUN npm install

# Copy all frontend files
COPY . .

# Build the app
RUN npm run build

# Start the Next.js app
CMD ["npm", "start"]
