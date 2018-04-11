FROM continuumio/anaconda3:5.1.0

RUN pip install -U pip setuptools

ADD . /opt/app/
WORKDIR /opt/app

RUN conda install pytorch torchvision -c pytorch

RUN pip install -r requirements-pretrain.txt
    # && apk del .build-deps  # donot purge since pytorch uses some of them in runtime!

ENV PYTHONPATH .
ENV DATA_DIR /opt/data/

CMD ["python", "pretrained_models/pretrained.py"]
