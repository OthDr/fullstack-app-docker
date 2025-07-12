export const APP_CONFIG = {
  API_BASE_URL: process.env.NEXT_PUBLIC_API_URL || 'http://localhost:8080/api/v1'
};

export const API_ENDPOINTS = {
  CLIENTS: {
    SEARCH: '/clients/search',
  },
};