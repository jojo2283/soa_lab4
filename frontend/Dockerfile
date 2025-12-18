# --- Стадия 1: build ---
FROM node:20 AS builder

WORKDIR /app

# Копируем только package.json и lock файл
COPY package*.json ./

# Устанавливаем зависимости
RUN npm ci --legacy-peer-deps

# Копируем весь код
COPY . .

# Сборка проекта
RUN npm run build


# --- Стадия 2: production image ---
FROM node:20-alpine AS runner

WORKDIR /app

ENV NODE_ENV=production

# Копируем нужные файлы из билдера
COPY --from=builder /app/public ./public
COPY --from=builder /app/.next ./.next
COPY --from=builder /app/package*.json ./

# Устанавливаем только продакшен-зависимости
RUN npm ci --omit=dev --legacy-peer-deps

EXPOSE 3000

CMD ["npm", "run", "start"]