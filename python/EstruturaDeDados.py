import abc


class EstruturaDeDados(abc.ABC):
    def __init__(self):
        self.counter = 0

    @abc.abstractmethod
    def insert(self, chave):
        pass

    @abc.abstractmethod
    def delete(self, chave):
        pass

    @abc.abstractmethod
    def search(self, chave):
        pass

    @abc.abstractmethod
    def minimum(self):
        pass

    @abc.abstractmethod
    def maximum(self):
        pass

    @abc.abstractmethod
    def sucessor(self, chave):
        pass

    @abc.abstractmethod
    def prodessor(self, chave):
        pass
